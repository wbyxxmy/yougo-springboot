package com.yexj.yougo.common.util;

import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;

import java.util.List;

/**
 * 实体类的数据转化
 */
public class CopyUtil {

    public static <B, S > void copy(B bo, S so)  {
        try {
            Class bc = bo.getClass();
            if (bo == null || so == null) {
                return;
            }
            DeserializeBeanInfo deserializeBeanInfo = DeserializeBeanInfo.computeSetters(so.getClass(), null);

            List<FieldInfo> getters = TypeUtils.computeGetters(bo.getClass(), null);
            List<FieldInfo> setters = deserializeBeanInfo.getFieldList();
            Object v;
            FieldInfo getterfield;
            FieldInfo setterfidld;
            for (int j = 0; j < getters.size(); j++) {
                getterfield = getters.get(j);
                for (int i = 0; i < setters.size(); i++) {
                    setterfidld = setters.get(i);
                    if (setterfidld.getName().compareTo(getterfield.getName()) == 0) {
                        v = getterfield.getMethod().invoke(bo);
                        setterfidld.getMethod().invoke(so, v);
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}