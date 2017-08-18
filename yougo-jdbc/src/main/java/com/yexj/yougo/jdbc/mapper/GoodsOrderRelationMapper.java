package com.yexj.yougo.jdbc.mapper;

import com.yexj.yougo.common.baseMapper.BaseMapper;
import com.yexj.yougo.jdbc.model.GoodsOrderRelation;
import java.util.List;

public interface GoodsOrderRelationMapper extends BaseMapper<GoodsOrderRelation, String> {
    List<GoodsOrderRelation> selectByParam(GoodsOrderRelation param);

    int selectCountByParam(GoodsOrderRelation param);
}