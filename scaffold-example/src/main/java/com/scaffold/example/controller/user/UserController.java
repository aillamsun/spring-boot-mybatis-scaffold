package com.scaffold.example.controller.user;

import com.scaffold.core.response.ResultBody;
import com.scaffold.core.response.ResultGenerator;
import com.scaffold.core.web.controller.BaseCRUDController;
import com.scaffold.example.service.UserServiceImpl;
import com.scaffold.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sungang on 2017/8/19.
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseCRUDController<User> {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping
    public ResultBody getAllUsers() {
        List<User> users = userService.selectAll();
        return ResultGenerator.genSuccessResult(users);
    }
}
