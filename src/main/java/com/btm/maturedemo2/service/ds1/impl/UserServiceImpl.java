package com.btm.maturedemo2.service.ds1.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.btm.maturedemo2.mapper.ds1.UserMapper;
import com.btm.maturedemo2.model.ds1.User;
import com.btm.maturedemo2.service.ds1.UserService;
import org.springframework.stereotype.Service;

/**
 * 声明一个接口的实现，实现我们自己自定义的接口
 * 并继承 com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
 *
 * @Author: BigTailMonkey
 * @Date: 2019/5/30 10:26
 * @Version: 1.0
 */

@Service("ds1UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
