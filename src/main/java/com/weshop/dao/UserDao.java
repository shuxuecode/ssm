package com.weshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsx.web.entity.User;

public interface UserDao {
	
    int deleteByPrimaryKey(@Param(value="id")String id);

    List<User> selectAll();
    
    int insert(User user);

    User selectByPrimaryKey(@Param(value="id")String id);


	
}