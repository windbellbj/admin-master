package com.lxl.admin.service.impl;

import com.lxl.admin.dao.BrandDao;
import com.lxl.admin.entity.Const;
import com.lxl.admin.entity.ResponseModel;
import com.lxl.admin.entity.User;
import com.lxl.admin.service.IBrandService;
import com.lxl.admin.util.DateUtil;
import com.lxl.admin.util.ParameterMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>BrandService</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/16</dd>
 * <dd></dd>
 * </dl>
 */
@SuppressWarnings("all")
@Service
public class BrandService implements IBrandService {

    @Autowired
    private BrandDao brandDao;

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<ParameterMap> getBrandList(ParameterMap pm) {
        pm.put("status", Const.DELETE);
        return brandDao.getBrandList(pm);
    }


    @Override
    public List<ParameterMap> getBrandListByOpen(ParameterMap pm) {
        pm.put("status", Const.OPEN);
        return brandDao.getBrandListByOpen(pm);
    }


    @Override
    public HashMap<String, Object> add(ParameterMap pm,HttpSession session) {
        try {
            pm.put("status", Const.OPEN);
            Integer count = brandDao.getCountByNo(pm);
            if(count > 0){
                return ResponseModel.getModel("品牌编码已存在", "falied", null);
            }
            pm.put("createTime", DateUtil.getTime());
            pm.put("updateTime", DateUtil.getTime());
            String userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
            pm.put("userId", userId);
            brandDao.saveBrand(pm);
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
            brandDao.editBrand(pm);

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
            brandDao.updateStatus(pm);

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            log.error("error:"+e.getMessage(), e);
            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }
}
