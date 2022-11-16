package com.gmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TGoods;
import com.gmall.service.impl.TGoodsServiceImpl;
import com.gmall.service.impl.TGoodsServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestTGoods;
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
@RequestMapping("/goods")
@Api(value = "商品", tags = "商品")
public class TGoodsController {
    @Autowired
    private TGoodsServiceImpl tGoodsService;


    @ApiOperation(value = "查询指定id的商品信息", notes = "查询指定id的商品信息")
    @GetMapping("/get")
    public Message<TGoods> get(Integer id) {
        return Message.FACTORY.success(tGoodsService.getById(id));
    }

    @ApiOperation(value = "查询商品列表", notes = "查询商品列表")
    @PostMapping("/list")
    public Message<List<TGoods>> get(@RequestBody TGoods goods) {
        LambdaQueryWrapper<TGoods> queryTGoods = Wrappers.lambdaQuery(TGoods.class);
        //queryTGoods.like(TGoods::getName,goods.getName());

        return Message.FACTORY.success(tGoodsService.list(queryTGoods));
    }

    @ApiOperation(value = "添加商品", notes = "添加商品")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody TGoods goods) {
        return Message.FACTORY.success(tGoodsService.save(goods));
    }

    @ApiOperation(value = "批量添加商品", notes = "批量添加商品")
    @PostMapping("/batch/add")
    public Message<List<TGoods>> batchAdd(@RequestBody List<TGoods> goodss) {
        return Message.FACTORY.success(tGoodsService.saveBatch(goodss));
    }

    @ApiOperation(value = "更新商品", notes = "更新商品")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody TGoods goods) {
        return Message.FACTORY.success(tGoodsService.updateById(goods));
    }

    @ApiOperation(value = "查询商品分页", notes = "查询商品分页")
    @PostMapping("/page")
    public Message<TGoods> page(@RequestBody RequestTGoods goods) {

        Page page = tGoodsService.initPage(goods);
        IPage<TGoods> iPage = tGoodsService.page(page);

        return Message.FACTORY.success(iPage);
    }
}

