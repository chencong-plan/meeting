package com.ssm.meeting.controller;

import com.ssm.meeting.common.ServerResponse;
import com.ssm.meeting.common.StatusConstant;
import com.ssm.meeting.pojo.User;
import com.ssm.meeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ccoder.cc
 * @since 2019/1/25 11:14
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(@ModelAttribute User user){
        User result = userService.userLogin(user);
        if (result == null){
            return new ServerResponse(StatusConstant.ResponseStatus.FAIL,"登录失败");
        }
        return new ServerResponse(StatusConstant.ResponseStatus.SUCCESS,"登录成功");
    }
}
