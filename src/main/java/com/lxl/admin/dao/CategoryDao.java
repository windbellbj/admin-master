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
public interface CategoryDao{
    List<ParameterMap> getCategoryList(ParameterMap pm);

    void saveCategory(ParameterMap pm);

    void editCategory(ParameterMap pm);

    Integer getCountByNo(ParameterMap pm);

    void updateStatus(ParameterMap pm);
}
