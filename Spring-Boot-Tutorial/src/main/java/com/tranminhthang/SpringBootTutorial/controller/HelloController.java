package com.tranminhthang.SpringBootTutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@RestController
public class HelloController {

    //@Value("${ten bien}") giup gan gia tri cua bien cho thuoc tinh phia duoi no
    @Value("${message}")
    private String welcomeMesage;

    @Value("${page2}")
    private String pageSecond;

    //@RequestMapping(value=<duong dan>,method = GET/POST/DELETE/...)
    //chi ra rang khi goi den duong dan(value) thi method se duoc doi duoi dang get/post/...(tuy chon)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello(){
        return welcomeMesage;
    }
    @RequestMapping(value = "/page2", method = RequestMethod.GET)
    public String page2(){
        return pageSecond;
    }
}
