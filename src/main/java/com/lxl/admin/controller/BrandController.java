package com.lxl.admin.controller;

import com.lxl.admin.annotation.Permission;
import com.lxl.admin.controller.base.BaseController;
import com.lxl.admin.entity.PermissionType;
import com.lxl.admin.service.IBrandService;
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
 * <dd>品牌管理</dd>
 * </dl>
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController {

    private final static String qxurl="brand/list";

    @Autowired
    private IBrandService brandService;
    /**
     * 品牌列表
     * @return
     */
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object list(Model model){
        model.addAttribute("brandList", brandService.getBrandList(this.getParameterMap()));
        return "page/brand/list";
    }

    @ResponseBody
    @RequestMapping(value="/getBrandList",method= RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object getBrandList(){
        return brandService.getBrandList(this.getParameterMap());
    }

    /**
     * 添加品牌
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(HttpSession session){
        return brandService.add(this.getParameterMap(),session);
    }

    /**
     * 删除品牌
     * @return
     */
    @RequestMapping(value="/del",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(HttpServletRequest request,HttpSession session){
        return brandService.del(this.getParameterMap(),session);
    }

    /**
     * 编辑品牌
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object edit(HttpSession session){
        return brandService.edit(this.getParameterMap(),session);
    }
}
