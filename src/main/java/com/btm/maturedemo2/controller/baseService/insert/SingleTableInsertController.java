package com.btm.maturedemo2.controller.baseService.insert;

import com.btm.maturedemo2.model.ds1.User;
import com.btm.maturedemo2.service.ds1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: BigTailMonkey
 * @Date: 2019/5/30 10:13
 * @Version: 1.0
 */

@RequestMapping("baseService/singleTableInsert")
@RestController("singleServiceInsert")
public class SingleTableInsertController {

    @Autowired
    private UserService ds1UserService;

    @GetMapping("insertBatch")
    public String insertBatch(){
        List<User> userList = new ArrayList<>();
        User user = new User(11l,"Tom",16,"test3@btm.com",new Date());
        return "Insert successfully"+ds1UserService.saveBatch(userList);
    }
}
