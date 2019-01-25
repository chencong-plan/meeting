package com.ssm.meeting.service;

import com.ssm.meeting.pojo.User;

/**
 * @author ccoder.cc
 * @since 2019/1/25 10:50
 */
public interface UserService {


    /**
     * 用户登录、可以通过用户名密码、邮箱进行登录
     *
     * @param user 参数
     * @return 当用户名密码、邮箱两者都为空时返回null
     */
    User userLogin(User user);
}
