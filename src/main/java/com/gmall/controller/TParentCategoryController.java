package com.gmall.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TParentCategory;
import com.gmall.service.impl.TParentCategoryServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestTParentCategory;
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
@RequestMapping("/parentCategory")
@Api(value = "菜单一级分类", tags = "菜单一级分类")
public class TParentCategoryController {

    @Autowired
    private TParentCategoryServiceImpl tParentCategoryService;


    @ApiOperation(value = "查询指定id的菜单一级分类信息", notes = "查询指定id的菜单一级分类信息")
    @GetMapping("/get")
    public Message<TParentCategory> get(Integer id) {
        return Message.FACTORY.success(tParentCategoryService.getById(id));
    }
    
    @ApiOperation(value = "查询菜单一级分类列表", notes = "查询菜单一级分类列表")
    @PostMapping("/list")
    public Message<List<TParentCategory>> get(@RequestBody TParentCategory parentCategory) {
        LambdaQueryWrapper<TParentCategory> queryTParentCategory = Wrappers.lambdaQuery(TParentCategory.class);

        if (!StringUtils.isEmpty(parentCategory.getName())){
            queryTParentCategory.like(TParentCategory::getName,parentCategory.getName());
        }


        return Message.FACTORY.success(tParentCategoryService.list(queryTParentCategory));
    }

    @ApiOperation(value = "添加菜单一级分类", notes = "添加菜单一级分类")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody TParentCategory parentCategory) {
        return Message.FACTORY.success(tParentCategoryService.save(parentCategory));
    }

    @ApiOperation(value = "批量添加菜单一级分类", notes = "批量添加菜单一级分类")
    @PostMapping("/batch/add")
    public Message<List<TParentCategory>> batchAdd(@RequestBody List<TParentCategory> parentCategorys) {
        return Message.FACTORY.success(tParentCategoryService.saveBatch(parentCategorys));
    }

    @ApiOperation(value = "更新菜单一级分类", notes = "更新菜单一级分类")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody TParentCategory parentCategory) {
        return Message.FACTORY.success(tParentCategoryService.updateById(parentCategory));
    }

    @ApiOperation(value = "查询菜单一级分类分页", notes = "查询菜单一级分类分页")
    @PostMapping("/page")
    public Message<TParentCategory> page(@RequestBody RequestTParentCategory parentCategory) {

        Page page = tParentCategoryService.initPage(parentCategory);
        IPage<TParentCategory> iPage = tParentCategoryService.page(page);

        return Message.FACTORY.success(iPage);
    }

}

