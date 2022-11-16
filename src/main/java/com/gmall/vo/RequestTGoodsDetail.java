package com.gmall.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.gmall.common.ListByPageQo;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author peiliang
 * @since 2022-11-14
 */
@Data
public class RequestTGoodsDetail extends ListByPageQo {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodId;

    /**
     * 商品详情URL
     */
    private String goodDetailUrl;


}
