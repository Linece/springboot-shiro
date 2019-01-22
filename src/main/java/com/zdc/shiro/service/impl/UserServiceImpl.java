package com.zdc.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdc.shiro.mapper.UserMapper;
import com.zdc.shiro.model.User;
import com.zdc.shiro.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

	@Override
	public User findById(Integer id) {
		return userMapper.findById(id);
	}
}
