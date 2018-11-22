package com.lxl.admin.dao;

import com.lxl.admin.entity.Brand;
import com.lxl.admin.util.ParameterMap;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>GoodsDao</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/15</dd>
 * <dd></dd>
 * </dl>
 */
@SuppressWarnings("all")
public interface BrandDao extends Mapper<Brand>{
    List<ParameterMap> getBrandList(ParameterMap pm);

    void saveBrand(ParameterMap pm);

    void editBrand(ParameterMap pm);

    Integer getCountByNo(ParameterMap pm);

    void updateStatus(ParameterMap pm);

    List<ParameterMap> getBrandListByOpen(ParameterMap pm);
}
