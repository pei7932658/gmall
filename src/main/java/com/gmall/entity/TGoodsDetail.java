package com.gmall.entity;

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
public class TGoodsDetail extends Model<TGoodsDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodId;

    /**
     * 商品详情URL
     */
    private String goodDetailUrl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodDetailUrl() {
        return goodDetailUrl;
    }

    public void setGoodDetailUrl(String goodDetailUrl) {
        this.goodDetailUrl = goodDetailUrl;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TGoodsDetail{" +
        "id=" + id +
        ", goodId=" + goodId +
        ", goodDetailUrl=" + goodDetailUrl +
        "}";
    }
}
