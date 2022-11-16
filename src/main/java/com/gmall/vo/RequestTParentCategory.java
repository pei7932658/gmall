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
public class RequestTParentCategory  extends ListByPageQo {


    /**
     * ID
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类排序
     */
    private Integer orderCode;


}
