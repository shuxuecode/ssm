package org.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.weixin.util.SignUtil;

@Controller
@RequestMapping("/wechatController")
public class WechatController {

	@RequestMapping(value = "/validate/{name}", method = RequestMethod.GET)
	public void wechatGet(HttpServletRequest request, HttpServletResponse response, @PathVariable String name)
			throws IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		// 根据参数获取该注册用户的信息——token ， 用于验证用户
		// WxAccount account = wechatService.getWxAccountByWxId(name);
		String token = "shuxue";
		// if (account != null && account.getToken() != null) {
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(token, signature, timestamp, nonce)) {
			out.print(echostr);
		}
		// }

		out.close();
		out = null;
	}

	@RequestMapping(value = "/validate/{name}", method = RequestMethod.POST)
	public void wechatPost(HttpServletResponse response, HttpServletRequest request, @PathVariable String name)
			throws IOException {
		// TODO Auto-generated method stub
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");

		// 根据参数获取该注册用户的信息， 用于验证用户
//
//		PrintWriter out = response.getWriter();
//		out.print("zhaoshuxue");
//		out.close();
		
		wechatGet(request, response, name);

	}
	
}
