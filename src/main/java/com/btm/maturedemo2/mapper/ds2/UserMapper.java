package com.btm.maturedemo2.mapper.ds2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.btm.maturedemo2.model.ds2.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: BigTailMonkey
 * @Date: 2019/5/28 17:09
 * @Version: 1.0
 */
@Repository("userMapperDs2")
public interface UserMapper extends BaseMapper<User> {
}
