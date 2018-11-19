package com.lxl.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <dl>
 * <dt>Brand</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/16</dd>
 * <dd></dd>
 * </dl>
 */
@SuppressWarnings("all")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer branId;
    private String brandNo;
    private String brandName;
    private String linkman;
    private String telephone;
    private String status;
    private Date createTime;
    private Date updateTime;
    private Integer userId;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBranId() {
        return branId;
    }

    public void setBranId(Integer branId) {
        this.branId = branId;
    }

    public String getBrandNo() {
        return brandNo;
    }

    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
