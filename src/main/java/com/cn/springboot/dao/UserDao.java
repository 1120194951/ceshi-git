package com.cn.springboot.dao;


import com.cn.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface UserDao {
    public User getUserByMassage(@Param("Username") String Username, @Param("password") String password);

    public List<User> getAllUser(@Param("username")String Username,@Param("pageStart")int PageStart,@Param("pageSize") int PageSize);

    public int geyUserCounts(@Param("username")String UserName);

    void updateUserList(@Param("id")int id,@Param("state") boolean state);

    int getUsername(@Param("username") String username);

    int insertUsername(User user);

    public User updateruleForm(int id);

    int updateUsername(int id, @Param("username")String username,@Param("password") String password,@Param("email") String email);

    int deleteUsername(int id);
}
