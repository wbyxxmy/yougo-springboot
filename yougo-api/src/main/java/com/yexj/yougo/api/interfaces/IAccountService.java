package com.yexj.yougo.api.interfaces;

import com.yexj.yougo.api.dto.account.UserCheckDTO;
import com.yexj.yougo.api.dto.account.UserParamDTO;
import com.yexj.yougo.api.dto.account.UserResultDTO;
import com.yexj.yougo.api.result.Result;

import java.util.List;

/**
 * Created by xinjian.ye on 2017/8/23.
 */
public interface IAccountService {
    Result<String> addUser(UserParamDTO userDTO);
    Result updateUser(UserParamDTO userDTO);
    Result<List<UserResultDTO>> searchUser(UserParamDTO userParamDTO);
    Result deleteUser(UserParamDTO userDTO);
    Result<UserResultDTO> checkUser(UserCheckDTO userCheckDTO);
}
