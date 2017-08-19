package com.scaffold.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sungang on 2017/8/19.
 */
@Slf4j
@Controller
@RequestMapping("auth")
public class AuthController {

    /**
     * @return
     */
    @GetMapping(value = "loginPage")
    public String loginPage() {
        return "/auth/login";
    }

}
