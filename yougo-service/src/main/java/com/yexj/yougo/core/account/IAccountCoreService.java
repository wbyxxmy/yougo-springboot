package com.yexj.yougo.core.account;

import com.yexj.yougo.api.result.Result;
import com.yexj.yougo.jdbc.model.Users;

import java.util.List;

/**
 * Created by xinjian.ye on 2017/8/18.
 */
public interface IAccountCoreService {
    Result addUser(Users users);
    Result updateUser(Users users);
    Result deleteUser(Users users);
    Result<List<Users>> searchUser(Users users);
}
