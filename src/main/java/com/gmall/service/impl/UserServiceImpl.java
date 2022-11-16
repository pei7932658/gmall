package com.gmall.service.impl;

import com.gmall.entity.User;
import com.gmall.dao.UserDao;
import com.gmall.service.BaseServiceImpl;
import com.gmall.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peiliang
 * @since 2022-11-10
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

}
