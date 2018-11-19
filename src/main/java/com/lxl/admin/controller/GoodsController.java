package com.lxl.admin.controller;

import com.lxl.admin.annotation.Permission;
import com.lxl.admin.controller.base.BaseController;
import com.lxl.admin.entity.PermissionType;
import com.lxl.admin.service.IGoodsService;
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
 * <dt>GoodsController</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/15</dd>
 * <dd>商品控制器</dd>
 * </dl>
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    private final static String qxurl="goods/list";

    @Autowired
    private IGoodsService goodsService;
    /**
     * 商品列表
     * @return
     */
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object login(Model model){
        model.addAttribute("goodsList", goodsService.getGoodsList(this.getParameterMap()));
        return "page/goods/list";
    }

    /**
     * 添加品牌
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(HttpSession session){
        return goodsService.add(this.getParameterMap(),session);
    }

    /**
     * 编辑商品
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(HttpSession session){
        return goodsService.edit(this.getParameterMap(),session);
    }

    /**
     * 删除品牌
     * @return
     */
    @RequestMapping(value="/del",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(HttpServletRequest request, HttpSession session){
        return goodsService.del(this.getParameterMap(),session);
    }
}
