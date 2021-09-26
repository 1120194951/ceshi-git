package com.cn.springboot.dao;

import com.cn.springboot.bean.MainMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ManuDao {

    public List<MainMenu> getManus();
}
