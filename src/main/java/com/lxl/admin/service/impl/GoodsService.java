package com.lxl.admin.service.impl;

import com.alibaba.druid.util.Base64;
import com.lxl.admin.dao.GoodsDao;
import com.lxl.admin.entity.Const;
import com.lxl.admin.entity.ResponseModel;
import com.lxl.admin.entity.User;
import com.lxl.admin.service.IGoodsService;
import com.lxl.admin.util.DateUtil;
import com.lxl.admin.util.ImgUtil;
import com.lxl.admin.util.ParameterMap;
import com.lxl.admin.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.lxl.admin.service.impl.UserService.replaceBase64Before;

/**
 * <dl>
 * <dt>GoodsService</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/15</dd>
 * <dd></dd>
 * </dl>
 */
@SuppressWarnings("all")
@Service
public class GoodsService implements IGoodsService {
    @Value("${upload.root.folder}")
    public String root_fold;

    @Value("${img.folder}")
    public String img_fold;

    @Value("${goods.folder}")
    public String goods_folder;

    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<ParameterMap> getGoodsList(ParameterMap pm) {
        pm.put("status", Const.OPEN);
        return goodsDao.getGoodsList(pm);
    }

    @Override
    public Object add(ParameterMap pm, HttpSession session) {
        try {
            pm.put("status", Const.OPEN);
            Integer count = goodsDao.getCountByNo(pm);
            if(count > 0){
                return ResponseModel.getModel("商品编码已存在", "falied", null);
            }
            String pics = pm.getString("picPath");
            if(Tools.notEmpty(pics)){
                pics = replaceBase64Before(pics);
                byte[] bytes = Base64.base64ToByteArray(pics);
                InputStream in = new ByteArrayInputStream(bytes);
                String filePath = goods_folder+Tools.random(8)+".png";
                String userPath = ImgUtil.uploadImg(root_fold,filePath, in);
                pm.put("picPath", userPath);
            }
            pm.put("createTime", DateUtil.getTime());
            pm.put("updateTime", DateUtil.getTime());
            String userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
            pm.put("userId", userId);
            goodsDao.saveGoods(pm);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            log.error("error:"+e.getMessage(), e);
            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> edit(ParameterMap pm, HttpSession session) {
        try {
            pm.put("updateTime", DateUtil.getTime());
            String userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
            pm.put("userId", userId);
            String pics = pm.getString("picPath");

            if(Tools.notEmpty(pics)){
                pics = replaceBase64Before(pics);
                byte[] bytes = Base64.base64ToByteArray(pics);
                InputStream in = new ByteArrayInputStream(bytes);
                String filePath = goods_folder+Tools.random(8)+".png";
                String goodsPath = ImgUtil.uploadImg(root_fold,filePath, in);
                pm.put("picPath", goodsPath);

                String oldPath = pm.getString("oldpath");
//                if(Tools.isEmpty(oldPath)){
//                    return ResponseModel.getModel("你请求的是冒牌接口", "falied", null);
//                }
                if(!"/images/logo.png".equals(oldPath)){
                    //删除旧头像
                    oldPath = oldPath.replaceAll("/upload/show","");
                    File file = new File(root_fold+oldPath);
                    if(file.isFile()){
                        file.delete();
                    }
                }
            }
            goodsDao.editGoods(pm);

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            log.error("error:"+e.getMessage(), e);
            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> del(ParameterMap pm, HttpSession session) {
        try {
            pm.put("updateTime", DateUtil.getTime());
            String userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
            pm.put("userId", userId);
            pm.put("status",Const.DELETE);
            goodsDao.updateStatus(pm);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            log.error("error:"+e.getMessage(), e);
            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }
}
