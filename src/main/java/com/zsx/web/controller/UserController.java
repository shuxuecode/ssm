package com.zsx.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zsx.web.entity.User;
import com.zsx.web.service.UserService;

/**
 * 用户
 * @author zsx
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * 跳转到用户管理模块
	 */
	@RequestMapping("toUserManager")
	public String toUserManager(){
		return "jsp/user/userManager";
	}

	/**
	 * 获取用户列表
	 */
	@RequestMapping("/getUserList")
	public void getJson(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		List<Tuser> list = userService.getAllUser();
		
		User user = userService.searchById("1");
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSONString(user));
		out.flush();
		out.close();
	}

}
