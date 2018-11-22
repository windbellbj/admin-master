package com.lxl.admin.dao;

import com.lxl.admin.entity.Category;
import com.lxl.admin.util.ParameterMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
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
@Repository
public interface CategoryDao extends Mapper<Category>{
//    @Select("select category.*,sys_user.username as username from category ,sys_user where sys_user.user_id = category.user_id AND category.status != #{status}")
    List<ParameterMap> getCategoryList(ParameterMap pm);

    void saveCategory(ParameterMap pm);

    void editCategory(ParameterMap pm);

    Integer getCountByNo(ParameterMap pm);

    void updateStatus(ParameterMap pm);

    List<ParameterMap> getCategoryListByOpen(ParameterMap pm);
}
