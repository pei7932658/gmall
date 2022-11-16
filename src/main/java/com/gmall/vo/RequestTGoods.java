package com.gmall.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.gmall.common.ListByPageQo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author peiliang
 * @since 2022-11-14
 */
@Data
public class RequestTGoods extends ListByPageQo {

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

}
