package com.cn.springboot.controller;

import com.cn.springboot.service.ManuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Manu")
public class ManuController {

    @Autowired
    ManuService service;


    @RequestMapping("/getAllMenus")
    public String getAllMenus(){
        String menus = service.getAllMenus();
        return menus;
    }
}
