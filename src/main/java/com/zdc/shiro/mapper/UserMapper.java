package com.zdc.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zdc.shiro.model.User;

@Mapper
public interface UserMapper {

	User findByUsername(@Param("name")String name);
	
	User findById(@Param("id")Integer id);
	
}
