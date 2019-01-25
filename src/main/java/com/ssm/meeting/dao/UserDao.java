package com.ssm.meeting.dao;

import com.ssm.meeting.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * UserDao
 *
 * @author ccoder.cc
 * @since 2019/1/25 10:48
 */
public interface UserDao {

    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return
     */
    User findUser(@Param("name") String name,@Param("password") String password);
}
