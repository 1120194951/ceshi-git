package com.cn.springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.cn.springboot.bean.MainMenu;
import com.cn.springboot.dao.ManuDao;
import com.cn.springboot.service.ManuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ManuServiceImpl implements ManuService {
    
    @Autowired
    ManuDao dao;
    
    @Override
    public String getAllMenus() {
        Map<String,Object> map = new HashMap<>();
        List<MainMenu> manus = dao.getManus();
        if(manus!=null){
            map.put("manus",manus);
            map.put("flag",200);
        }else {
            map.put("flag",400);
        }

       String data = JSON.toJSONString(map);
       return data;
    }
}
