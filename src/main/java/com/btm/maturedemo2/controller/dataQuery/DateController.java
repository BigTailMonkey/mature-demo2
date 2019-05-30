package com.btm.maturedemo2.controller.dataQuery;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btm.maturedemo2.mapper.ds1.UserMapper;
import com.btm.maturedemo2.model.ds1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: BigTailMonkey
 * @Date: 2019/5/29 21:09
 * @Version: 1.0
 */
@RestController
@RequestMapping("date")
public class DateController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("dateResultDateConditional")
    public String dateResultDateConditional(){
        //声明一个查询条件包装器
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //添加查询条件：create_date=str_to_date('2019-05-01 19:29:35','%Y-%m-%d %H:%i:%s')
        userQueryWrapper.apply("create_date = str_to_date({0},'%Y-%m-%d %H:%i:%s')","2019-05-01 19:29:35");
        //应用条件包装器查询单条数据
        List<User> user = userMapper.selectList(userQueryWrapper);
        return null != user ? user.toString() : "No result.";
    }

}
