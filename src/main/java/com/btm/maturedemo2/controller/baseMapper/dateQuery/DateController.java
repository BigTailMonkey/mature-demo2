package com.btm.maturedemo2.controller.baseMapper.dateQuery;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btm.maturedemo2.mapper.ds1.UserMapper;
import com.btm.maturedemo2.model.ds1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 时间 单表 单条件查询
 * @Author: BigTailMonkey
 * @Date: 2019/5/29 21:09
 * @Version: 1.0
 */
@RestController
@RequestMapping("date")
public class DateController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询结果中的时间字段精度由实体中相应字段的类型决定
     * 具体请参考 com.btm.maturedemo2.model.ds1.User
     *
     * 单条件 时间条件
     * 条件形式：param1=value1
     * 多结果 包含时间字段
     *
     * @return
     */
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
