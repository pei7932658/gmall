package com.gmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TOrder;
import com.gmall.service.impl.TOrderServiceImpl;
import com.gmall.service.impl.TOrderServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestTOrder;
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
@RequestMapping("/order")
@Api(value = "订单", tags = "订单")
public class TOrderController {
    @Autowired
    private TOrderServiceImpl tOrderService;


    @ApiOperation(value = "查询指定id的订单信息", notes = "查询指定id的订单信息")
    @GetMapping("/get")
    public Message<TOrder> get(Integer id) {
        return Message.FACTORY.success(tOrderService.getById(id));
    }

    @ApiOperation(value = "查询订单列表", notes = "查询订单列表")
    @PostMapping("/list")
    public Message<List<TOrder>> get(@RequestBody TOrder order) {
        LambdaQueryWrapper<TOrder> queryTOrder = Wrappers.lambdaQuery(TOrder.class);
        //queryTOrder.like(TOrder::getName,order.getName());

        return Message.FACTORY.success(tOrderService.list(queryTOrder));
    }

    @ApiOperation(value = "添加订单", notes = "添加订单")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody TOrder order) {
        return Message.FACTORY.success(tOrderService.save(order));
    }

    @ApiOperation(value = "批量添加订单", notes = "批量添加订单")
    @PostMapping("/batch/add")
    public Message<List<TOrder>> batchAdd(@RequestBody List<TOrder> orders) {
        return Message.FACTORY.success(tOrderService.saveBatch(orders));
    }

    @ApiOperation(value = "更新订单", notes = "更新订单")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody TOrder order) {
        return Message.FACTORY.success(tOrderService.updateById(order));
    }

    @ApiOperation(value = "查询订单分页", notes = "查询订单分页")
    @PostMapping("/page")
    public Message<TOrder> page(@RequestBody RequestTOrder order) {

        Page page = tOrderService.initPage(order);
        IPage<TOrder> iPage = tOrderService.page(page);

        return Message.FACTORY.success(iPage);
    }
}

