package com.cn.springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.cn.springboot.bean.QueryInfo;
import com.cn.springboot.bean.User;
import com.cn.springboot.dao.UserDao;
import com.cn.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public User getUserByMassage(String username, String password) {
        User user = dao.getUserByMassage(username, password);
        return user;
    }

    @Override
    public String getUserList(QueryInfo queryInfo) {
        //获取最大列表数
        int numbers = dao.geyUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> users = dao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> map = new HashMap<>();
        map.put("numbars", numbers);
        map.put("data", users);

        String s = JSON.toJSONString(map);
        return s;
    }

    @Override
    public void updateUserList(User user) {
        dao.updateUserList(user.getId(), user.isState());

    }

    @Override
    public int getUsername(String username) {
        return dao.getUsername(username);

    }

    @Override
    public int insertUsername(User user) {
        return dao.insertUsername(user);

    }

    @Override
    public User updateruleForm(int id) {
        return dao.updateruleForm(id);
    }

    @Override
    public int updateUsername(User user) {
        int i = dao.updateUsername(user.getId(),user.getUsername(),user.getPassword(),user.getEmail());

        return i;
    }

    @Override
    public int deleteUserid(int id) {
       return dao.deleteUsername(id);
    }


}
