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
public class TGoodsBanner extends Model<TGoodsBanner> {

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
     * 商品bannerURL
     */
    private String goodBannerUrl;


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

    public String getGoodBannerUrl() {
        return goodBannerUrl;
    }

    public void setGoodBannerUrl(String goodBannerUrl) {
        this.goodBannerUrl = goodBannerUrl;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TGoodsBanner{" +
        "id=" + id +
        ", goodId=" + goodId +
        ", goodBannerUrl=" + goodBannerUrl +
        "}";
    }
}
