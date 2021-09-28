package com.cn.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.cn.springboot.bean.QueryInfo;
import com.cn.springboot.bean.User;
import com.cn.springboot.service.UserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/getUserList")
    public String getUserList(@RequestBody QueryInfo queryInfo) {
        String s = service.getUserList(queryInfo);
        return s;
    }

    @PostMapping("/updateUserList")
    public void updateUserList(@RequestBody User user) {
        service.updateUserList(user);

    }

    @PostMapping("/insertUsername")
    public String insertUsername(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        int i = service.getUsername(user.getUsername());
        if (i >= 1) {
            map.put("succes", "用户名重复");
            map.put("flag", "添加失败");
        } else {
            user.setRole("普通用户");
            user.setState(false);
            int userid = service.insertUsername(user);
            if (userid >= 1) {
                map.put("succes", "");
                map.put("flag", "添加成功");
            }
        }
        String s = JSON.toJSONString(map);
        return s;
    }
    @GetMapping("/updateruleForm")
    public User updateruleForm(int id){
        User user = service.updateruleForm(id);
        return user;
    }

    @PostMapping("/updateUsername")
    public String updateUsername(@RequestBody User user){
        Map<String,Object> map= new Hashtable<String,Object>();
        int i = service.updateUsername(user);
        if (i >= 1) {
            map.put("succes", "");
            map.put("flag", "修改成功");
        }
        String s = JSON.toJSONString(map);
        return s;
    }

    @GetMapping("/deleteUserid")
    public String deleteUserid(int id){
        Map<String,Object> map= new Hashtable<String,Object>();
        int i = service.deleteUserid(id);
        if (i >= 1) {
            map.put("succes", "");
            map.put("flag", "删除成功");
        }
        String s = JSON.toJSONString(map);
        return s;
    }
}
