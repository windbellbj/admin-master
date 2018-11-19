package com.lxl.admin.service;

import com.lxl.admin.util.ParameterMap;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>IBrandService</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/16</dd>
 * <dd></dd>
 * </dl>
 */
@SuppressWarnings("all")
@Component
public interface ICategoryService {
    public List<ParameterMap> getCategoryList(ParameterMap parameterMap);

    public HashMap<String, Object> add(ParameterMap parameterMap, HttpSession session);

    public Map<String,Object> edit(ParameterMap parameterMap, HttpSession session);

    public Map<String,Object> del(ParameterMap parameterMap, HttpSession session);
}
