package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.Shop;
import java.util.List;

public interface ShopMapper extends BaseMapper<Shop, String> {
    List<Shop> selectByParam(Shop param);

    int selectCountByParam(Shop param);
}