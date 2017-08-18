package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.Users;
import java.util.List;

public interface UsersMapper extends BaseMapper<Users, String> {
    List<Users> selectByParam(Users param);

    int selectCountByParam(Users param);
}