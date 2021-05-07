package com.sun.controller;

import com.sun.annotation.UserAnnotation;
import com.sun.service.UserService;
import org.springframework.stereotype.Controller;

/**
 * create by qiulisun on 2020/11/16.<br>
 */
@Controller
public class UserController {

    @UserAnnotation
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
