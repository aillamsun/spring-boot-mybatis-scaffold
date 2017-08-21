package com.scaffold.mapper.user;

import com.scaffold.core.dao.mybatis.BaseMapper;
import com.scaffold.model.User;

import java.util.Map;

/**
 * Created by sungang on 2017/8/19.
 */
public interface UserMapper extends BaseMapper<User> {

    User selectUserAndAuthorities(Map<String,Object> params);
}
