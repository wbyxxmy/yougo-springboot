package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.Account;
import java.util.List;

public interface AccountMapper extends BaseMapper<Account, Integer> {
    List<Account> selectByParam(Account param);

    int selectCountByParam(Account param);
}