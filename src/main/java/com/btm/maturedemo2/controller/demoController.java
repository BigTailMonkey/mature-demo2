package com.btm.maturedemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: BigTailMonkey
 * @Date: 2019/5/29 14:50
 * @Version: 1.0
 */
@RestController
@RequestMapping("test")
public class demoController {

    @Autowired
    private com.btm.maturedemo2.mapper.ds1.UserMapper userMapperds1;

    @Autowired
    private com.btm.maturedemo2.mapper.ds2.UserMapper userMapperds2;

    @GetMapping("test")
    public void testSelect() {
        System.out.println("使用数据源 ds1 读取数据");
        List<com.btm.maturedemo2.model.ds1.User> userListDs1 = userMapperds1.selectList(null);
        userListDs1.forEach(System.out::println);
        System.out.println("使用数据源 ds2 读取数据");
        List<com.btm.maturedemo2.model.ds2.User> userListDs2 = userMapperds2.selectList(null);
        userListDs2.forEach(System.out::println);
    }
}
