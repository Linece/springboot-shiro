package com.zdc.shiro.service;

import org.apache.ibatis.annotations.Param;

import com.zdc.shiro.model.User;

public interface UserService {

	User findByUsername(String username);
	
	User findById(Integer id);
}
