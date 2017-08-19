package com.scaffold.example.service;

import com.scaffold.core.service.BaseService;
import com.scaffold.mapper.user.UserMapper;
import com.scaffold.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungang on 2017/8/19.
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {


    @Autowired
    private UserMapper userMapper;

}
