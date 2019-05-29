package com.btm.maturedemo2.controller.select;

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
 * 更多QueryWrapper条件构造器（包装器）的使用请参考：https://mp.baomidou.com/guide/wrapper.html
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
     * 条件形式：param1=value1
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
        return null != user ? user.toString() : "No result.";
    }

    /**
     * 单条件
     * 条件形式：param1=value1
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
        return null != user ? user.toString() : "No result.";
    }

    /**
     * 时间条件查询
     * <p>
     * 单条件
     * 条件形式：param1=value1
     * 多结果
     *
     * @return
     */
    @GetMapping("dataConditional")
    public String dataConditional(){
        //声明一个查询条件包装器
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //添加查询条件：create_date=str_to_date('2019-05-01 19:29:35','%Y-%m-%d %H:%i:%s')
        userQueryWrapper.apply("create_date = str_to_date({0},'%Y-%m-%d %H:%i:%s')","2019-05-01 19:29:35");
        //应用条件包装器查询单条数据
        List<User> user = userMapper.selectList(userQueryWrapper);
        return null != user ? user.toString() : "No result.";

    }

    /**
     * 多条件
     * 条件形式：param1=value1 and param2=value2
     * 多结果
     *
     * @return
     */
    @GetMapping("multiResultMultiConditional1")
    public String multiResultMultiConditional1() {
        //声明一个查询条件包装器
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //添加查询条件：name='btm'
        userQueryWrapper.eq("name", "btm");
        //添加查询条件：age=19
        userQueryWrapper.eq("age", 19);
        //应用条件包装器查询单条数据
        List<User> user = userMapper.selectList(userQueryWrapper);
        return null != user ? user.toString() : "No result.";
    }

    /**
     * 多条件
     * 条件形式：param1=value1 or param2=value2
     * 多结果
     *
     * @return
     */
    @GetMapping("multiResultMultiConditional2")
    public String multiResultMultiConditional2() {
        //声明一个查询条件包装器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //添加查询条件：name='btm'
        queryWrapper.eq("name", "btm")
                //添加 or 条件关联关键字
                .or()
                //添加查询条件：name='Jone'
                .eq("name", "Jone");
        List<User> list = userMapper.selectList(queryWrapper);
        return null != list ? list.toString() : "No result.";
    }


    /**
     * 多条件
     * 条件形式： param1=value1 and (param2=value2 or param3=value3)
     * 多结果
     *
     * @return
     */
    @GetMapping("multiResultMultiConditionalAndNestedOr")
    public String multiResultMultiConditionalAndNestedOr() {
        //声明一个查询条件包装器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //添加查询条件：age='18'
        queryWrapper.eq("age", "18")
                //嵌套 and 条件关联关键字
                .and(
                        //添加查询条件：name='btm'
                        i -> i.eq("name", "btm")
                                //添加 or 条件关联关键字
                                .or()
                                //添加查询条件：name='Jone'
                                .eq("name", "Jone"));
        List<User> list = userMapper.selectList(queryWrapper);
        return null != list ? list.toString() : "No result.";
    }

    /**
     * 多条件
     * 条件形式： param1=value1 or (param2=value2 and param3=value3)
     * 多结果
     *
     * @return
     */
    @GetMapping("multiResultMultiConditionalOrNestedAnd")
    public String multiResultMultiConditionalOrNestedAnd() {
        //声明一个查询条件包装器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //添加查询条件：age>'20'
        queryWrapper.gt("age", "20")
                //嵌套 and 条件关联关键字
                .or(
                        //添加查询条件：name='btm'
                        i -> i.eq("name", "btm")
                                //添加查询条件：age='19'
                                .eq("age", "19"));
        List<User> list = userMapper.selectList(queryWrapper);
        return null != list ? list.toString() : "No result.";
    }

}
