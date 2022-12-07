package com.study.springboot202210dongbin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controller1 {

//    @RequestMapping(value = "/page1", method = RequestMethod.GET) 아래 한줄로 줄여서 사용가능
    @GetMapping("/page1")
    public String page1() {
        return "page1";
    }

    @GetMapping("/page2")
    public String page2() {
        return "page2";
    }
}
