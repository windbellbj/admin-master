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
@Table(name = "brand")
public class Brand extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;
    @Column
    private String brandNo;
    @Column
    private String brandName;
    @Column
    private String linkman;
    @Column
    private String telephone;



    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
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

}
