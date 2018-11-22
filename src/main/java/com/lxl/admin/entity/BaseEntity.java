package com.lxl.admin.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * <dl>
 * <dt>BaseEntity</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/22</dd>
 * <dd></dd>
 * </dl>
 */
@SuppressWarnings("all")
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    private Integer status;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
    @Column
    private Integer userId;

    private String username;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
