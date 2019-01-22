package com.zdc.shiro.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.zdc.shiro.model.User;
import com.zdc.shiro.service.UserService;

public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;

	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		/**
		 * geizi
		 * 给资源授权
		 */
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//添加授权字符串
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		info.addStringPermission(user.getPerms());
		return info;
	}

	/**
	 * 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		
		UsernamePasswordToken tokenparam = (UsernamePasswordToken)token;
		User user = userService.findByUsername(tokenparam.getUsername());
		if (user == null) {
			return null;
		}
		
		//判断密码
		//第一个参数login返回的参数；第二个：用户名密码;第三个shiro的名称
		return new SimpleAuthenticationInfo(user, user.getPassword(), "");
	}

}
