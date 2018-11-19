package com.lxl.admin.service;

import com.lxl.admin.util.ParameterMap;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>IGoodsService</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/15</dd>
 * <dd></dd>
 * </dl>
 */
@SuppressWarnings("all")
@Component
public interface IGoodsService {
    public List<ParameterMap> getGoodsList(ParameterMap parameterMap);

    Object add(ParameterMap parameterMap, HttpSession session);

    Map<String, Object> edit(ParameterMap parameterMap, HttpSession session);

    Map<String, Object> del(ParameterMap parameterMap, HttpSession session);
}
