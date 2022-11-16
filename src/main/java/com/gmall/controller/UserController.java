package com.gmall.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmall.entity.TParentCategory;
import com.gmall.entity.User;
import com.gmall.service.impl.UserServiceImpl;
import com.gmall.vo.Message;
import com.gmall.vo.RequestUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author peiliang
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户信息", tags = "用户信息")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "查询指定id的用户信息", notes = "查询指定id的用户信息")
    @GetMapping("/get")
    public Message<User> get(Integer id) {
        redisTemplate.opsForValue().set("peiliang", "张三");
        return Message.FACTORY.success(userService.getById(id));
    }

    //https://blog.51cto.com/u_15733182/5755033
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    @PostMapping("/list")
    public Message<List<User>> get(@RequestBody User user) {
        LambdaQueryWrapper<User> queryUser = Wrappers.lambdaQuery(User.class);

        if (!StringUtils.isEmpty(user.getName())){
            queryUser.like(User::getName,user.getName());
        }


        return Message.FACTORY.success(userService.list(queryUser));
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping("/add")
    public Message<Boolean> save(@RequestBody User user) {
//        user.setcTime(LocalDateTime.now());
//        user.setuTime(LocalDateTime.now());
        return Message.FACTORY.success(userService.save(user));
    }

    @ApiOperation(value = "批量添加用户", notes = "批量添加用户")
    @PostMapping("/batch/add")
    public Message<List<User>> batchAdd(@RequestBody List<User> users) {

//        users.stream().forEach(u -> {
//            u.setcTime(LocalDateTime.now());
//            u.setuTime(LocalDateTime.now());
//        });

        return Message.FACTORY.success(userService.saveBatch(users));
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PostMapping("/update")
    public Message<Boolean> update(@RequestBody User user) {
        //user.setuTime(LocalDateTime.now());
        return Message.FACTORY.success(userService.updateById(user));
    }

    @ApiOperation(value = "查询用户分页", notes = "查询用户分页")
    @PostMapping("/page")
    public Message<User> page(@RequestBody RequestUser user) {

        Page page = userService.initPage(user);
        IPage<User> iPage = userService.page(page);

        return Message.FACTORY.success(iPage);
    }

}

