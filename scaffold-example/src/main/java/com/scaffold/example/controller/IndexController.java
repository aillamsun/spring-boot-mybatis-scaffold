package com.scaffold.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sungang on 2017/8/19.
 */
@Controller
@RequestMapping("dashboard")
public class IndexController {


    @GetMapping
    public String index() {
        return "dashboard/index";
    }
}
