package com.gmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TCategory;
import com.gmall.service.impl.TCategoryServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestTCategory;
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
@RequestMapping("/category")
@Api(value = "二级菜单", tags = "二级菜单")
public class TCategoryController {
    @Autowired
    private TCategoryServiceImpl tCategoryService;


    @ApiOperation(value = "查询指定id的二级菜单信息", notes = "查询指定id的二级菜单信息")
    @GetMapping("/get")
    public Message<TCategory> get(Integer id) {
        return Message.FACTORY.success(tCategoryService.getById(id));
    }

    @ApiOperation(value = "查询二级菜单列表", notes = "查询二级菜单列表")
    @PostMapping("/list")
    public Message<List<TCategory>> get(@RequestBody TCategory category) {
        LambdaQueryWrapper<TCategory> queryTCategory = Wrappers.lambdaQuery(TCategory.class);
        //queryTCategory.like(TCategory::getName,category.getName());

        return Message.FACTORY.success(tCategoryService.list(queryTCategory));
    }

    @ApiOperation(value = "添加二级菜单", notes = "添加二级菜单")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody TCategory category) {
        return Message.FACTORY.success(tCategoryService.save(category));
    }

    @ApiOperation(value = "批量添加二级菜单", notes = "批量添加二级菜单")
    @PostMapping("/batch/add")
    public Message<List<TCategory>> batchAdd(@RequestBody List<TCategory> categorys) {
        return Message.FACTORY.success(tCategoryService.saveBatch(categorys));
    }

    @ApiOperation(value = "更新二级菜单", notes = "更新二级菜单")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody TCategory category) {
        return Message.FACTORY.success(tCategoryService.updateById(category));
    }

    @ApiOperation(value = "查询二级菜单分页", notes = "查询二级菜单分页")
    @PostMapping("/page")
    public Message<TCategory> page(@RequestBody RequestTCategory category) {

        Page page = tCategoryService.initPage(category);
        IPage<TCategory> iPage = tCategoryService.page(page);

        return Message.FACTORY.success(iPage);
    }
}

