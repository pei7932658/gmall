package com.gmall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gmall.common.ListByPageQo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/4/22 11:04
 * @Version 1.0
 **/
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M, T> {

    public void setQueryTimeType(QueryWrapper queryWrapper, ListByPageQo reqQo, String dateType) {
        if(reqQo.getStartTime()!=null){
            queryWrapper.ge(dateType,reqQo.getStartTime());
        }
        if(reqQo.getEndTime()!=null){
            queryWrapper.le(dateType,reqQo.getEndTime());
        }
    }
    public Page initPage(ListByPageQo reqQo) {
        Page page = new Page(reqQo.getPageNo(),reqQo.getPageSize());



        List<OrderItem> orderItems = new ArrayList<>();
        if(reqQo.getAscs()!=null){
            Arrays.stream(reqQo.getAscs()).forEach(s->{
                orderItems.add(new OrderItem(s,false));
            });
        }
        if(reqQo.getDescs()!=null){
            Arrays.stream(reqQo.getDescs()).forEach(s->{
                orderItems.add(new OrderItem(s,true));
            });
        }
        page.setOrders(orderItems);
        return page;
    }
}
