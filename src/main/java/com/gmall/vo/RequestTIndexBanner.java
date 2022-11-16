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
public class RequestTIndexBanner extends ListByPageQo {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 图片URL1
     */
    private String picUrl1;

    /**
     * 图片URL2
     */
    private String picUrl2;

    /**
     * 图片URL3
     */
    private String picUrl3;


}
