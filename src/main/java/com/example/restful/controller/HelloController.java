package com.example.restful.controller;

import com.example.restful.common.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public CommonResponse<String> hello(){
        return CommonResponse.createForSuccess("hello");
    }
}
