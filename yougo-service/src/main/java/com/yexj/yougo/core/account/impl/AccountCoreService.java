package com.yexj.yougo.core.account.impl;

import com.yexj.yougo.api.result.Result;
import com.yexj.yougo.core.account.IAccountCoreService;
import com.yexj.yougo.jdbc.mapper.UsersMapper;
import com.yexj.yougo.jdbc.model.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账户管理类,用于对用户信息的增删查改
 * Created by xinjian.ye on 2017/8/18.
 */
@Service
public class AccountCoreService implements IAccountCoreService{

    @Resource
    private UsersMapper usersMapper;
    @Override
    public Result addUser(Users users) {
        Result result = Result.newSuccess();
        usersMapper.intsertSelective(users);
        return result;
    }

    @Override
    public Result updateUser(Users users) {
        Result result = Result.newSuccess();
        usersMapper.updateByPrimaryKeySelective(users);
        return result;
    }

    @Override
    public Result deleteUser(Users users) {
        Result result = Result.newSuccess();
        usersMapper.deleteByPrimaryKey(users.getUserId());
        return result;
    }

    @Override
    public Result<List<Users>> searchUser(Users users) {
        Result<List<Users>> result = Result.newSuccess();
        List<Users> usersList = usersMapper.selectByParam(users);
        result.setData(usersList);
        return result;
    }
}
