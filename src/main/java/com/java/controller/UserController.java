package com.java.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.User;
import com.java.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Log4j2
public class UserController {
    @Autowired
    private IUserService userService;


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

    @RequestMapping("selectOne")
    @ResponseBody
    public Object selectOne(){
        Long start = System.currentTimeMillis();
        User user = userService.selectOneUser();
        Long end = System.currentTimeMillis();
        log.info("查询消耗时间:"+(end-start)+"ms");
        return user;
    }


    @RequestMapping("insertUser")
    @ResponseBody
    public Object insertUserOne(User user){
        userService.insertUserOne(user);
        return user;
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public Object updateUser(User user){
        user.updateById();
        return user;
    }
}
