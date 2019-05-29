package com.btm.maturedemo2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btm.maturedemo2.mapper.ds1.UserMapper;
import com.btm.maturedemo2.model.ds1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 使用单表查询
 *
 * @Author: BigTailMonkey
 * @Date: 2019/5/29 17:15
 * @Version: 1.0
 */

@RequestMapping("singleTable")
@RestController
public class SingleTableController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 单条件
     * 单结果
     * <p>
     * 此种情况需要确保返回结果中最多包含一条返回数据
     * 对应数据库字段应保证使用了唯一性约束，不然有发生
     * org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 2
     * 异常的风险
     *
     * @return
     */
    @GetMapping("singleResultSingleConditional")
    public String singleResultSingleConditional() {
        //声明一个查询条件包装器
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //添加查询条件：name='Jone'
        userQueryWrapper.eq("name", "Jone");
        //应用条件包装器查询单条数据
        User user = userMapper.selectOne(userQueryWrapper);
        if (null != user)
            return user.toString();
        else
            return "No result.";
    }

    /**
     * 单条件
     * 多结果
     *
     * @return
     */
    @GetMapping("multiResultSingleConditional")
    public String multiResultSingleConditional() {
        //声明一个查询条件包装器
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //添加查询条件：name='btm'
        userQueryWrapper.eq("name", "btm");
        //应用条件包装器查询单条数据
        List<User> user = userMapper.selectList(userQueryWrapper);
        if (null != user)
            return user.toString();
        else
            return "No result.";
    }

}
