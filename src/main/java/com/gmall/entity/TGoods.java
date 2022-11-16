package com.gmall.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author peiliang
 * @since 2022-11-14
 */
public class TGoods extends Model<TGoods> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品简介
     */
    private String nameDetail;

    /**
     * 商品图片URL
     */
    private String picMainUrl;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 打折商品价格
     */
    private BigDecimal discountPrice;

    /**
     * 已经下单数量
     */
    private Integer orderdNum;

    /**
     * 商品排序
     */
    private Integer orderCode;

    /**
     * 备注
     */
    private String remark;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameDetail() {
        return nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public String getPicMainUrl() {
        return picMainUrl;
    }

    public void setPicMainUrl(String picMainUrl) {
        this.picMainUrl = picMainUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getOrderdNum() {
        return orderdNum;
    }

    public void setOrderdNum(Integer orderdNum) {
        this.orderdNum = orderdNum;
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TGoods{" +
        "id=" + id +
        ", categoryId=" +  categoryId+
        ", name=" + name +
        ", nameDetail=" + nameDetail +
        ", picMainUrl=" + picMainUrl +
        ", price=" + price +
        ", discountPrice=" + discountPrice +
        ", orderdNum=" + orderdNum +
        ", orderCode=" + orderCode +
        ", remark=" + remark +
        "}";
    }
}
