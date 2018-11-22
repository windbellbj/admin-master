package com.lxl.admin.entity;

import javax.persistence.*;
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
@Entity
@Table(name = "category")
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column
    private String categoryName;
    @Column
    private Integer userId;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
