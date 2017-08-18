package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.Goods;
import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods, String> {
    List<Goods> selectByParam(Goods param);

    int selectCountByParam(Goods param);
}