package com.yexj.yougo.service.account;

import com.yexj.yougo.api.dto.account.UserCheckDTO;
import com.yexj.yougo.api.dto.account.UserParamDTO;
import com.yexj.yougo.api.dto.account.UserResultDTO;
import com.yexj.yougo.api.enums.ResultCode;
import com.yexj.yougo.api.interfaces.IAccountService;
import com.yexj.yougo.api.result.Result;
import com.yexj.yougo.common.util.CopyUtil;
import com.yexj.yougo.core.account.IAccountCoreService;
import com.yexj.yougo.jdbc.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinjian.ye on 2017/8/18.
 */
@Service
public class AccountService implements IAccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
    @Autowired
    private IAccountCoreService accountCoreService;

    @Override
    public Result<String> addUser(UserParamDTO userDTO) {
        Result<String> result = Result.newSuccess();
        try {
            Users users = new Users();
            CopyUtil.copy(userDTO, users);
            result = this.accountCoreService.addUser(users);
        }catch (Exception e) {
            result.setCode(ResultCode.FAIL.getCode());
            result.setMessage(ResultCode.FAIL.getMessage());
            logger.error("新增用户失败 -- {}", e);
            return result;
        }
        logger.info("新增用户成功 -- 用户名:{}",userDTO.getUserName());
        return result;
    }

    @Override
    public Result updateUser(UserParamDTO userDTO) {
        Result<String> result = Result.newSuccess();
        try {
            Users users = new Users();
            CopyUtil.copy(userDTO, users);
            result = this.accountCoreService.updateUser(users);
        }catch (Exception e) {
            result.setCode(ResultCode.FAIL.getCode());
            result.setMessage(ResultCode.FAIL.getMessage());
            logger.error("更新用户失败 -- {}", e);
            return result;
        }
        logger.info("更新 用户名:{}信息成功",userDTO.getUserName());
        return result;
    }

    @Override
    public Result<List<UserResultDTO>> searchUser(UserParamDTO userDTO) {
        Result<List<UserResultDTO>> result = Result.newSuccess();
        List<UserResultDTO> userResultDTOList = new ArrayList<UserResultDTO>();
        try {
            Users users = new Users();
            CopyUtil.copy(userDTO, users);
            List<Users> usersList = new ArrayList<Users>();
            usersList = this.accountCoreService.searchUser(users).getData();
            if(!CollectionUtils.isEmpty(usersList)) {
                for(Users users1 : usersList) {
                    UserResultDTO userResultDTO = new UserResultDTO();
                    CopyUtil.copy(users1, userResultDTO);
                    userResultDTOList.add(userResultDTO);
                }
                result.setData(userResultDTOList);
            }
        }catch (Exception e) {
            result.setCode(ResultCode.FAIL.getCode());
            result.setMessage(ResultCode.FAIL.getMessage());
            logger.error("查询用户信息失败 -- {}", e);
            return result;
        }
        logger.info("查询用户成功 -- {}",result.getData());
        return result;
    }

    @Override
    public Result deleteUser(UserParamDTO userDTO) {
        Result<String> result = Result.newSuccess();
        try {
            Users users = new Users();
            CopyUtil.copy(userDTO, users);
            result = this.accountCoreService.deleteUser(users);
        }catch (Exception e) {
            result.setErrorCode(ResultCode.FAIL);
            logger.error("删除用户失败 -- {}", e);
            return result;
        }
        logger.info("删除 用户名:{}信息成功",userDTO.getUserName());
        return result;
    }

    @Override
    public Result<UserResultDTO> checkUser(UserCheckDTO userCheckDTO) {
        Result<UserResultDTO> result = Result.newSuccess();
        Result<List<Users>> resultUser = new Result<List<Users>>();
        try {
            Users users = new Users();
            CopyUtil.copy(userCheckDTO, users);
            resultUser = accountCoreService.searchUser(users);
            if(ResultCode.SUCCESS.getCode().equals(resultUser.getCode())) {
                if(!CollectionUtils.isEmpty(resultUser.getData())) {
                    if(resultUser.getData().size() != 1) {
                        logger.info("用户名或密码不存在! -- {}", userCheckDTO);
                        result.setErrorCode(ResultCode.ACCOUNT_LOGIN_FAIL);
                    }
                    else {
                        UserResultDTO userResultDTO = new UserResultDTO();
                        CopyUtil.copy(resultUser.getData().get(0), userResultDTO);
                        result.setData(userResultDTO);
                    }
                }
            }
            return result;
        }catch (Exception e) {
            logger.error("用户登录失败 -- {}", e);
            result.setErrorCode(ResultCode.FAIL);
            return result;
        }
    }
}
