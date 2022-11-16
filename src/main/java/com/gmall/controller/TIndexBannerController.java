package com.gmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TIndexBanner;
import com.gmall.service.impl.TIndexBannerServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestTIndexBanner;
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
@RequestMapping("/indexBanner")
@Api(value = "首页banner", tags = "首页banner")
public class TIndexBannerController {
    @Autowired
    private TIndexBannerServiceImpl tIndexBannerService;


    @ApiOperation(value = "查询指定id的首页banner信息", notes = "查询指定id的首页banner信息")
    @GetMapping("/get")
    public Message<TIndexBanner> get(Integer id) {
        return Message.FACTORY.success(tIndexBannerService.getById(id));
    }

    @ApiOperation(value = "查询首页banner列表", notes = "查询首页banner列表")
    @PostMapping("/list")
    public Message<List<TIndexBanner>> get(@RequestBody TIndexBanner indexBanner) {
        LambdaQueryWrapper<TIndexBanner> queryTIndexBanner = Wrappers.lambdaQuery(TIndexBanner.class);
        //queryTIndexBanner.like(TIndexBanner::getName,indexBanner.getName());

        return Message.FACTORY.success(tIndexBannerService.list(queryTIndexBanner));
    }

    @ApiOperation(value = "添加首页banner", notes = "添加首页banner")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody TIndexBanner indexBanner) {
        return Message.FACTORY.success(tIndexBannerService.save(indexBanner));
    }

    @ApiOperation(value = "批量添加首页banner", notes = "批量添加首页banner")
    @PostMapping("/batch/add")
    public Message<List<TIndexBanner>> batchAdd(@RequestBody List<TIndexBanner> indexBanners) {
        return Message.FACTORY.success(tIndexBannerService.saveBatch(indexBanners));
    }

    @ApiOperation(value = "更新首页banner", notes = "更新首页banner")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody TIndexBanner indexBanner) {
        return Message.FACTORY.success(tIndexBannerService.updateById(indexBanner));
    }

    @ApiOperation(value = "查询首页banner分页", notes = "查询首页banner分页")
    @PostMapping("/page")
    public Message<TIndexBanner> page(@RequestBody RequestTIndexBanner indexBanner) {

        Page page = tIndexBannerService.initPage(indexBanner);
        IPage<TIndexBanner> iPage = tIndexBannerService.page(page);

        return Message.FACTORY.success(iPage);
    }
}

