package com.pbq.subject.user.controller;

import com.pbq.common.po.UserPo;
import com.pbq.common.response.ApiResponse;
import com.pbq.subject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/TestCall")
    public ApiResponse testCall(){
        return ApiResponse.succ(userService.testCall());
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody UserPo userPo){
        String token = userService.login(userPo.getUserName(), userPo.getPassword());
        if (token == null) {
            return ApiResponse.error("login fail");
        }
        return ApiResponse.succ(token);
    }
}
