package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.Orders;
import java.util.List;

public interface OrdersMapper extends BaseMapper<Orders, String> {
    List<Orders> selectByParam(Orders param);

    int selectCountByParam(Orders param);
}