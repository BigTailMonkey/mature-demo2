package com.btm.maturedemo2.controller.baseMapper.insert;

import com.btm.maturedemo2.mapper.ds1.UserMapper;
import com.btm.maturedemo2.model.ds1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 使用单表插入
 * 更多QueryWrapper条件构造器（包装器）的使用请参考：https://mp.baomidou.com/guide/wrapper.html
 *
 * @Author: BigTailMonkey
 * @Date: 2019/5/30 9:14
 * @Version: 1.0
 */

@RestController("singleInsert")
@RequestMapping("singleTableInsert")
public class SingleTableController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 一次插入一条数据
     * @return
     */
    @GetMapping("insertOne")
    public String insertOne(){
        User user = new User();
        user.setId(9l);
        user.setName("Btm");
        user.setAge(22);
        user.setEmail("test1@btm.com");
        user.setCreateDate(new Timestamp(new Date().getTime()));
        return "Insert successful ："+userMapper.insert(user);
    }

    /**
     * 批量插入功能参考 com.btm.maturedemo2.baseService 包下的demo
     */
}

