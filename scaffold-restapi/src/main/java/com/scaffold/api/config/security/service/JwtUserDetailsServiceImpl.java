package com.scaffold.api.config.security.service;

import com.google.common.collect.Maps;
import com.scaffold.api.config.security.JwtUserFactory;
import com.scaffold.core.service.BaseService;
import com.scaffold.mapper.user.UserMapper;
import com.scaffold.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserDetailsServiceImpl extends BaseService<User> implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, Object> params = Maps.newHashMap();
        params.put("userName", username);
        User user = userMapper.selectUserAndAuthorities(params);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
