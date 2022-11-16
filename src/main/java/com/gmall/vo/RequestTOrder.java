package com.gmall.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gmall.common.ListByPageQo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author peiliang
 * @since 2022-11-14
 */
@Data
public class RequestTOrder extends ListByPageQo {

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


}
