package com.sun;

import com.sun.annotation.UserAnnotation;
import com.sun.controller.UserController;
import com.sun.service.UserService;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * create by qiulisun on 2020/11/17.<br>
 */
public class UserTest2 {

    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        UserService userService = new UserService();

        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            UserAnnotation annotation = field.getAnnotation(UserAnnotation.class);
            if (annotation != null) {
                field.setAccessible(true);
                // 获取属性类型
                Class<?> type = field.getType();
                try {
                    Object instance = type.newInstance();
                    field.set(userController, instance);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());
    }
}
