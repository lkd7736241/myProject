package com.sun;

import com.sun.controller.UserController;
import com.sun.service.UserService;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * create by qiulisun on 2020/11/16.<br>
 */
public class UserTest {

    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        // 创建要调用的对象
        UserService userService = new UserService();
        // 获取所有属性值
        Field userServiceField = clazz.getDeclaredField("userService");
        userServiceField.setAccessible(true);
        // 拼接方法名称
        String fieldName = userServiceField.getName();
        fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
        String methodName = "set" + fieldName;
        // 通过方法注入属性的对象
        Method method = clazz.getMethod(methodName, UserService.class);
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());
    }
}
