package com.lxl.admin.controller;

import com.lxl.admin.annotation.Permission;
import com.lxl.admin.controller.base.BaseController;
import com.lxl.admin.entity.PermissionType;
import com.lxl.admin.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>BrandController</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/16</dd>
 * <dd>品类管理</dd>
 * </dl>
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    private final static String qxurl="category/list";

    @Autowired
    private ICategoryService categoryService;
    /**
     * 品类列表
     * @return
     */
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object list(Model model){
        model.addAttribute("categoryList", categoryService.getCategoryList(this.getParameterMap()));
        return "page/category/list";
    }

    @ResponseBody
    @RequestMapping(value="/getCategoryList",method= RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object getCategoryList(Model model){
        return categoryService.getCategoryList(this.getParameterMap());
    }

    /**
     * 添加品类
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(HttpSession session){
        return categoryService.add(this.getParameterMap(),session);
    }

    /**
     * 删除品类
     * @return
     */
    @RequestMapping(value="/del",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(HttpServletRequest request,HttpSession session){
        return categoryService.del(this.getParameterMap(),session);
    }

    /**
     * 编辑品类
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object edit(HttpSession session){
        return categoryService.edit(this.getParameterMap(),session);
    }
}
