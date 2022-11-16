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
public class TGoodsGroup extends Model<TGoodsGroup> {

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
     * 消费者姓名
     */
    private String consumerName;

    /**
     * 消费者图像
     */
    private String consumerIcon;


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

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerIcon() {
        return consumerIcon;
    }

    public void setConsumerIcon(String consumerIcon) {
        this.consumerIcon = consumerIcon;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TGoodsGroup{" +
        "id=" + id +
        ", goodsId=" + goodsId +
        ", consumerName=" + consumerName +
        ", consumerIcon=" + consumerIcon +
        "}";
    }
}
