package com.lxl.admin.dao;

import com.lxl.admin.entity.Goods;
import com.lxl.admin.util.ParameterMap;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <dl>
 * <dt>GoodsDao</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/15</dd>
 * <dd></dd>
 * </dl>
 */
@SuppressWarnings("all")
public interface GoodsDao extends Mapper<Goods> {
    List<ParameterMap> getGoodsList(ParameterMap pm);

    Integer getCountByNo(ParameterMap pm);

    void saveGoods(ParameterMap pm);

    void editGoods(ParameterMap pm);

    void updateStatus(ParameterMap pm);
}
