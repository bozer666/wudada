package com.java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.User;
import com.java.mapper.UserMapper;
import com.java.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wu
 * @since 2018-10-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "user",keyGenerator = "keyGenerator")
    @Override
    public User selectOneUser() {
        return userMapper.selectOneUser();
    }
}
