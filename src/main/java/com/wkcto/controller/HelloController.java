package com.wkcto.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ����
 * @create 2021-04-09 17:31
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String sayHello(){
        return "ʹ���ڴ��е��û���Ϣ";
    }

    @RequestMapping("helloUser")
    @PreAuthorize(value = "hasAnyRole('admin','normal')")
    public String helloCommonUser(){
        return "ӵ��normal��admin��ɫ�û�";
    }

    //ָ��adminר�еķ���
    @RequestMapping("helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin(){
        return "admin��ɫ�û����Է���";
    }
}
