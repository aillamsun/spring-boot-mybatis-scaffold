package com.scaffold.api.controller.auth;

import com.google.common.collect.Maps;
import com.scaffold.api.config.security.JwtAuthenticationRequest;
import com.scaffold.api.config.security.JwtTokenUtil;
import com.scaffold.api.config.security.JwtUser;
import com.scaffold.core.enums.ErrorInfoEnum;
import com.scaffold.core.exception.GlobalErrorInfoException;
import com.scaffold.core.response.ResultBody;
import com.scaffold.core.response.ResultGenerator;
import com.scaffold.mapper.user.UserAuthortyMapper;
import com.scaffold.mapper.user.UserMapper;
import com.scaffold.model.User;
import com.scaffold.model.UserAuthorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by sungang on 2017/8/19.
 */
@RestController
@RequestMapping("auth")
public class AuthenticationController {


    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserAuthortyMapper userAuthortyMapper;
    @Autowired
    private UserMapper userMapper;


    /**
     *
     * @param userToAdd
     * @return
     * @throws GlobalErrorInfoException
     */
    @PostMapping("register")
    public ResultBody register(User userToAdd) throws GlobalErrorInfoException {
        final String username = userToAdd.getUserName();
        Map<String, Object> params = Maps.newHashMap();
        params.put("userName", username);
        if (userMapper.selectUserAndAuthorities(params) != null) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.USER_EXISTS);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        userToAdd.setEmail("");
        userToAdd.setEnabled(true);
        userMapper.insert(userToAdd);


        UserAuthorty userAuthorty = new UserAuthorty();
        userAuthorty.setAuthorityId(1L);
        userAuthorty.setUserId(userToAdd.getId());


        userAuthortyMapper.insert(userAuthorty);

        return ResultGenerator.genSuccessResult();
    }


    @PostMapping
    public ResultBody createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
        // Perform the security
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);
        // Return the token
        return ResultGenerator.genSuccessResult(token);
    }

    /**
     * @param request
     * @return
     */
    @GetMapping(value = "refresh")
    public ResultBody refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResultGenerator.genSuccessResult(refreshedToken);
        } else {
            return ResultGenerator.genSuccessResult();
        }
    }

}
