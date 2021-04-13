package com.wkcto.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁超
 * @create 2021-04-09 17:31
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String sayHello(){
        return "使用内存中的用户信息";
    }

    @RequestMapping("helloUser")
    @PreAuthorize(value = "hasAnyRole('admin','normal')")
    public String helloCommonUser(){
        return "拥有normal和admin角色用户";
    }

    //指定admin专有的方法
    @RequestMapping("helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin(){
        return "admin角色用户可以访问";
    }
}
