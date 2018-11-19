package com.lxl.admin.dao;

import com.lxl.admin.util.ParameterMap;

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
public interface GoodsDao {
    List<ParameterMap> getGoodsList(ParameterMap pm);

    Integer getCountByNo(ParameterMap pm);

    void saveGoods(ParameterMap pm);

    void editGoods(ParameterMap pm);

    void updateStatus(ParameterMap pm);
}
