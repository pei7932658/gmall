package com.gmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TGoodsGroup;
import com.gmall.service.impl.TGoodsGroupServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestTGoodsGroup;
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
@RequestMapping("/goodsGroup")
@Api(value = "商品拼团组", tags = "商品拼团组")
public class TGoodsGroupController {
    @Autowired
    private TGoodsGroupServiceImpl tGoodsGroupService;


    @ApiOperation(value = "查询指定id的商品拼团组信息", notes = "查询指定id的商品拼团组信息")
    @GetMapping("/get")
    public Message<TGoodsGroup> get(Integer id) {
        return Message.FACTORY.success(tGoodsGroupService.getById(id));
    }

    @ApiOperation(value = "查询商品拼团组列表", notes = "查询商品拼团组列表")
    @PostMapping("/list")
    public Message<List<TGoodsGroup>> get(@RequestBody TGoodsGroup goodsGroup) {
        LambdaQueryWrapper<TGoodsGroup> queryTGoodsGroup = Wrappers.lambdaQuery(TGoodsGroup.class);
        //queryTGoodsGroup.like(TGoodsGroup::getName,goodsGroup.getName());

        return Message.FACTORY.success(tGoodsGroupService.list(queryTGoodsGroup));
    }

    @ApiOperation(value = "添加商品拼团组", notes = "添加商品拼团组")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody TGoodsGroup goodsGroup) {
        return Message.FACTORY.success(tGoodsGroupService.save(goodsGroup));
    }

    @ApiOperation(value = "批量添加商品拼团组", notes = "批量添加商品拼团组")
    @PostMapping("/batch/add")
    public Message<List<TGoodsGroup>> batchAdd(@RequestBody List<TGoodsGroup> goodsGroups) {
        return Message.FACTORY.success(tGoodsGroupService.saveBatch(goodsGroups));
    }

    @ApiOperation(value = "更新商品拼团组", notes = "更新商品拼团组")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody TGoodsGroup goodsGroup) {
        return Message.FACTORY.success(tGoodsGroupService.updateById(goodsGroup));
    }

    @ApiOperation(value = "查询商品拼团组分页", notes = "查询商品拼团组分页")
    @PostMapping("/page")
    public Message<TGoodsGroup> page(@RequestBody RequestTGoodsGroup goodsGroup) {

        Page page = tGoodsGroupService.initPage(goodsGroup);
        IPage<TGoodsGroup> iPage = tGoodsGroupService.page(page);

        return Message.FACTORY.success(iPage);
    }
}

