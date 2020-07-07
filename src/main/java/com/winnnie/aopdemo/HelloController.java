package com.winnnie.aopdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author winnie [wangliu023@qq.com]
 * @date 2020/7/7
 */
@RestController()
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(){
        return "hello world";
    }
}
