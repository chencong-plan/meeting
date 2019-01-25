package com.ssm.meeting.service.impl;

import com.ssm.meeting.dao.UserDao;
import com.ssm.meeting.pojo.User;
import com.ssm.meeting.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ccoder.cc
 * @since 2019/1/25 10:51
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User userLogin(User user) {
        if (null == user) {
            return null;
        }
        if (StringUtils.isBlank(user.getName()) && StringUtils.isBlank(user.getPassword())) {
            return null;
        }
        return userDao.findUser(user.getName(),user.getPassword());
    }
}
