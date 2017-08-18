package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.OrderControl;
import java.util.List;

public interface OrderControlMapper extends BaseMapper<OrderControl, String> {
    List<OrderControl> selectByParam(OrderControl param);

    int selectCountByParam(OrderControl param);
}