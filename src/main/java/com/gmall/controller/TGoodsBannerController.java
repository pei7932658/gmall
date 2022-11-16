package com.gmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TGoodsBanner;
import com.gmall.service.impl.TGoodsBannerServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestTGoodsBanner;
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
@RequestMapping("/goodsBanner")
@Api(value = "商品banner", tags = "商品banner")
public class TGoodsBannerController {
    @Autowired
    private TGoodsBannerServiceImpl tGoodsBannerService;


    @ApiOperation(value = "查询指定id的商品banner信息", notes = "查询指定id的商品banner信息")
    @GetMapping("/get")
    public Message<TGoodsBanner> get(Integer id) {
        return Message.FACTORY.success(tGoodsBannerService.getById(id));
    }

    @ApiOperation(value = "查询商品banner列表", notes = "查询商品banner列表")
    @PostMapping("/list")
    public Message<List<TGoodsBanner>> get(@RequestBody TGoodsBanner goodsBanner) {
        LambdaQueryWrapper<TGoodsBanner> queryTGoodsBanner = Wrappers.lambdaQuery(TGoodsBanner.class);
        //queryTGoodsBanner.like(TGoodsBanner::getName,goodsBanner.getName());

        return Message.FACTORY.success(tGoodsBannerService.list(queryTGoodsBanner));
    }

    @ApiOperation(value = "添加商品banner", notes = "添加商品banner")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody TGoodsBanner goodsBanner) {
        return Message.FACTORY.success(tGoodsBannerService.save(goodsBanner));
    }

    @ApiOperation(value = "批量添加商品banner", notes = "批量添加商品banner")
    @PostMapping("/batch/add")
    public Message<List<TGoodsBanner>> batchAdd(@RequestBody List<TGoodsBanner> goodsBanners) {
        return Message.FACTORY.success(tGoodsBannerService.saveBatch(goodsBanners));
    }

    @ApiOperation(value = "更新商品banner", notes = "更新商品banner")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody TGoodsBanner goodsBanner) {
        return Message.FACTORY.success(tGoodsBannerService.updateById(goodsBanner));
    }

    @ApiOperation(value = "查询商品banner分页", notes = "查询商品banner分页")
    @PostMapping("/page")
    public Message<TGoodsBanner> page(@RequestBody RequestTGoodsBanner goodsBanner) {

        Page page = tGoodsBannerService.initPage(goodsBanner);
        IPage<TGoodsBanner> iPage = tGoodsBannerService.page(page);

        return Message.FACTORY.success(iPage);
    }
}

