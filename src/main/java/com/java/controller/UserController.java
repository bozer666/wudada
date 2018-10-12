package com.java.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wu
 * @since 2018-10-12
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("insert")
    @ResponseBody
    public Object insert(User user){
        user.insert();
        return "插入的id为:"+user.getId();
    }

    @RequestMapping("page")
    @ResponseBody
    public Object page(Page<User> page,User user){
        return user.selectPage(page,new QueryWrapper<>(user));
    }
}
