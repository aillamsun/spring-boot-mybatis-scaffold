package com.scaffold.example.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by sungang on 2017/8/19.
 */
@Data
@ConfigurationProperties(prefix = "secure")
public class Secure {

    /**
     * 登录页面地址
     */
    private String loginPage;

    /**
     * 成功跳转地址
     */
    private String loginSuccessUrl = "/";

    /**
     * 处理登录请求地址
     */
    private String loginProcessingUrl = "login";


    /**
     * 登录跳转
     */
    private String oauthLoginProcessingUrl = "/auth";

    /**
     * 登出地址
     */
    private String logoutUrl = "logout";


    /**
     * 过期
     */
    private String expireUrl = "/auth/loginPage?param.error=expired";


    /**
     * 权限不够
     */
    private String accessDeniedUrl;

    /**
     * 认证失败
     */
    private String badCredentialsUrl;


}
