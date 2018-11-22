package com.lxl.admin.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * <dl>
 * <dt>Goods</dt>
 * <dd>@auther lixinlong</dd>
 * <dd>@create 2018/11/15</dd>
 * <dd>商品类</dd>
 * </dl>
 */
@SuppressWarnings("all")
@Entity
@Table(name = "goods")
public class Goods extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goodsId;
    @Column
    private String goodsNo;
    @Column
    private String goodsName;
    @Column
    private String title;
    @Column
    private String goodsDesc;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

}
