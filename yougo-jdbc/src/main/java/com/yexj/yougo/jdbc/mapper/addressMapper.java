package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.address;
import java.util.List;

public interface addressMapper extends BaseMapper<address, Integer> {
    List<address> selectByParam(address param);

    int selectCountByParam(address param);
}