package com.scaffold.example.controller;

import com.scaffold.core.response.ResultBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sungang on 2017/8/19.
 */
@RestController
@RequestMapping("test")
public class TestController {


    @GetMapping
    public ResultBody get() {
        return new ResultBody();
    }
}
