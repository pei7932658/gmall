package com.gmall.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.gmall.common.ListByPageQo;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author peiliang
 * @since 2022-11-14
 */
@Data
public class RequestTGoodsGroup extends ListByPageQo {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
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

}
