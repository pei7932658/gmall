package com.gmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TGoodsDetail;
import com.gmall.service.impl.TGoodsDetailServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestTGoodsDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author peiliang
 * @since 2022-11-14
 */
@RestController
@RequestMapping("/goodsDetail")
@Api(value = "商品详情", tags = "商品详情")
public class TGoodsDetailController {
    @Autowired
    private TGoodsDetailServiceImpl tGoodsDetailService;


    @ApiOperation(value = "查询指定id的商品详情信息", notes = "查询指定id的商品详情信息")
    @GetMapping("/get")
    public Message<TGoodsDetail> get(Integer id) {
        return Message.FACTORY.success(tGoodsDetailService.getById(id));
    }

    @ApiOperation(value = "查询商品详情列表", notes = "查询商品详情列表")
    @PostMapping("/list")
    public Message<List<TGoodsDetail>> get(@RequestBody TGoodsDetail goodsDetail) {
        LambdaQueryWrapper<TGoodsDetail> queryTGoodsDetail = Wrappers.lambdaQuery(TGoodsDetail.class);
        //queryTGoodsDetail.like(TGoodsDetail::getName,goodsDetail.getName());

        return Message.FACTORY.success(tGoodsDetailService.list(queryTGoodsDetail));
    }

    @ApiOperation(value = "添加商品详情", notes = "添加商品详情")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody TGoodsDetail goodsDetail) {
        return Message.FACTORY.success(tGoodsDetailService.save(goodsDetail));
    }

    @ApiOperation(value = "批量添加商品详情", notes = "批量添加商品详情")
    @PostMapping("/batch/add")
    public Message<List<TGoodsDetail>> batchAdd(@RequestBody List<TGoodsDetail> goodsDetails) {
        return Message.FACTORY.success(tGoodsDetailService.saveBatch(goodsDetails));
    }

    @ApiOperation(value = "更新商品详情", notes = "更新商品详情")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody TGoodsDetail goodsDetail) {
        return Message.FACTORY.success(tGoodsDetailService.updateById(goodsDetail));
    }

    @ApiOperation(value = "查询商品详情分页", notes = "查询商品详情分页")
    @PostMapping("/page")
    public Message<TGoodsDetail> page(@RequestBody RequestTGoodsDetail goodsDetail) {

        Page page = tGoodsDetailService.initPage(goodsDetail);
        IPage<TGoodsDetail> iPage = tGoodsDetailService.page(page);

        return Message.FACTORY.success(iPage);
    }
}

