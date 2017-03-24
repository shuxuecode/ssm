package org.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.weixin.entity.message.resp.TextMessage;
import org.weixin.util.MessageUtil;
import org.weixin.util.SignUtil;

@Controller
@RequestMapping("/wechat")
public class WechatController {

	@RequestMapping(value = "/validate/{name}", method = RequestMethod.GET)
	public void wechatGet(HttpServletRequest request, HttpServletResponse response, @PathVariable String name)
			throws IOException {
		System.out.println("进来了吗 come in ");
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
			System.out.println("a wo shi fanhui :  " + echostr);
			
			out.print(echostr);
		}
		// }

		out.close();
		out = null;
	}

	@RequestMapping(value = "/validate/{name}", method = RequestMethod.POST)
	public void wechatPost(HttpServletResponse response, HttpServletRequest request, @PathVariable String name)
			throws Exception {
		// TODO Auto-generated method stub
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 根据参数获取该注册用户的信息， 用于验证用户
		//

		// 默认返回的文本消息内容
		String respContent = "请求处理异常，请稍候尝试！";

		// xml请求解析
		Map<String, String> requestMap = MessageUtil.parseXml(request);

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		//
		String msgId = requestMap.get("MsgId");

		String createTime = requestMap.get("CreateTime");

		System.out.println(fromUserName);
		System.out.println(toUserName);
		System.out.println(msgType);
		System.out.println(msgId);
		System.out.println(createTime);
		
		// 默认回复此文本消息
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setContent(respContent + requestMap.get("Content"));

		
		
		
		// 将文本消息对象转换成xml字符串
		String respMessage = ""; // MessageUtil.textMessageToXml(textMessage);
		
		respMessage = "<xml>";
		respMessage += "<ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>";
		respMessage += "<FromUserName><![CDATA[" + toUserName + "]]></FromUserName>";
		respMessage += "<CreateTime>" + new Date().getTime() + "</CreateTime>";
		respMessage += "<MsgType><![CDATA[text]]></MsgType>";
		respMessage += "<Content><![CDATA[" + requestMap.get("Content") + "]]></Content>";
		respMessage += "</xml>";
		

		System.out.println(respMessage);
		
		// wechatGet(request, response, name);
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();

	}

}
