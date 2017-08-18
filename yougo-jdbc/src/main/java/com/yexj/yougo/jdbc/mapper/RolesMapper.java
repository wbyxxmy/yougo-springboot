package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.Roles;
import java.util.List;

public interface RolesMapper extends BaseMapper<Roles, Integer> {
    List<Roles> selectByParam(Roles param);

    int selectCountByParam(Roles param);
}