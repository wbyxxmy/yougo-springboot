package com.yexj.yougo.common.baseMapper;

import java.io.Serializable;
import java.util.List;

/**
 * T 对象类型 E example PK 主键类型
 * Created by xinjian.ye on 2017/5/4.
 * Time: 23:52
 */

public interface BaseMapper<T, PK extends Serializable> {

    List<T> selectByPrimaryKey(PK pk);

    int deleteByPrimaryKey(PK pk);

    int insert(T record);

    int intsertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    //long countByExample(E example);
    //int deleteByExample(E example);
    //List<T> selectByExample(E example);
    //T selectByPrimaryKey(PK pk);
    //int updateByExampleSelective(@Param("record") T record, @Param("example") E example);
    //int updateByExample(@Param("record") T record, @Param("example") E example);
}
