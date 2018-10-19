package com.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wu
 * @since 2018-10-12
 */
public interface UserMapper extends BaseMapper<User> {

    User selectOneUser();

    Integer insertUserOne(User user);
}
