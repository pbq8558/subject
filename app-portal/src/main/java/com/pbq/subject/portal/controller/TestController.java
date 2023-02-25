package com.pbq.subject.portal.controller;

import com.pbq.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/test")
public class TestController {

    @Value("${portalName}")
    public String name;

    @GetMapping("/getName")
    public ApiResponse getName(){
        return ApiResponse.succ(name);
    }
}
