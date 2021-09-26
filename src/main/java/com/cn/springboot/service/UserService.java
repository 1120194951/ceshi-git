package com.cn.springboot.service;

import com.cn.springboot.bean.QueryInfo;
import com.cn.springboot.bean.User;

public interface UserService {
    User getUserByMassage(String username, String password);


    String getUserList(QueryInfo queryInfo);

    void updateUserList(User user);

    int getUsername(String username);

    int insertUsername(User user);
}