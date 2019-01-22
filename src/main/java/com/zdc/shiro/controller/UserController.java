package com.zdc.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/test")
	public String test(Model model){
		model.addAttribute("name", "zs");
		return "test";
	}
	
	@RequestMapping("/add")
	public String toAdd(Model model){
		model.addAttribute("name", "zs");
		return "user/add";
	}
	
	@RequestMapping("/update")
	public String toupdate(Model model){
		model.addAttribute("name", "zs");
		return "user/update";
	}
	
	@RequestMapping("/noAuth")
	public String noAuth(Model model){
		return "noAuth";
	}
	
	@RequestMapping("/tologin")
	public String toLogin(Model model){
		model.addAttribute("name", "zs");
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String name,String password,Model model){
		System.out.println("name="+name);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
		
		try {
			subject.login(usernamePasswordToken);
			return "redirect:/user/test";
		} catch (UnknownAccountException e) {
			model.addAttribute("msg", "账户不存在");
			return "login";
		}catch (IncorrectCredentialsException e) {
			model.addAttribute("msg", "密码错误");
			return "login";
		}
		
	}
}
