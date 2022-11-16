package com.gmall.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author peiliang
 * @since 2022-11-14
 */
public class TOrder extends Model<TOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 下单数量
     */
    private Integer orderNum;

    /**
     * 下单单价
     */
    private BigDecimal orderPrice;

    /**
     * 下单总价
     */
    private BigDecimal orderCount;

    /**
     * 一起拼单用户ID
     */
    private Integer orderGoodsGroupId;

    /**
     * 用户ID
     */
    private String tUserId;

    /**
     * 支持方式
     */
    private Integer payType;

    /**
     * 下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tTime;

    /**
     * 拼单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tGroupTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrderGoodsGroupId() {
        return orderGoodsGroupId;
    }

    public void setOrderGoodsGroupId(Integer orderGoodsGroupId) {
        this.orderGoodsGroupId = orderGoodsGroupId;
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public LocalDateTime gettTime() {
        return tTime;
    }

    public void settTime(LocalDateTime tTime) {
        this.tTime = tTime;
    }

    public LocalDateTime gettGroupTime() {
        return tGroupTime;
    }

    public void settGroupTime(LocalDateTime tGroupTime) {
        this.tGroupTime = tGroupTime;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TOrder{" +
        "id=" + id +
        ", goodsId=" + goodsId +
        ", orderNum=" + orderNum +
        ", orderPrice=" + orderPrice +
        ", orderCount=" + orderCount +
        ", orderGoodsGroupId=" + orderGoodsGroupId +
        ", tUserId=" + tUserId +
        ", payType=" + payType +
        ", tTime=" + tTime +
        ", tGroupTime=" + tGroupTime +
        "}";
    }
}
