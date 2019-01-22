package com.zdc.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {

	/**
	 * 创建ShiroFilterFactoryBean
	 */
	
	@Bean
	public ShiroFilterFactoryBean getshiroFilterFactoryBen(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		//添加shiro内置过滤器 可以实现权限相关拦截器
		/**
		 * 常用过滤器
		 *      anon:无需认证访问
		 *      authc:必须认证才可以访问
		 *      user:如果使用rememberMe的功能可以直接访问
		 *      perms:该资源必须得到资源权限才可以访问
		 *      role:该资源必须得到角色权限才能访问
		 */
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		
		filterChainDefinitionMap.put("/user/login", "anon");
		filterChainDefinitionMap.put("/user/add", "perms[user:add]");
		filterChainDefinitionMap.put("/user/update", "perms[user:update]");
		filterChainDefinitionMap.put("/user/**", "authc");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		shiroFilterFactoryBean.setLoginUrl("/user/tologin");
		shiroFilterFactoryBean.setUnauthorizedUrl("/user/noAuth");
		return shiroFilterFactoryBean;
	}
	
	/**
	 * 创建DefaultWebSecurityManager 安全管理器
	 */
	
	@Bean(name = "defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		//关联realm
		defaultWebSecurityManager.setRealm(userRealm);
		return defaultWebSecurityManager;
	}
	/**
	 * 创建realm
	 */
	
	@Bean(name = "userRealm")
	public UserRealm getRealm(){
		return new UserRealm();
	}
	
	@Bean
	public ShiroDialect getShiroDialect(){
		return new ShiroDialect();
	}
}
