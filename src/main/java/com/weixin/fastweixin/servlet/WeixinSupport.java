package com.weixin.fastweixin.servlet;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.fastweixin.handle.EventHandle;
import com.weixin.fastweixin.handle.MessageHandle;
import com.weixin.fastweixin.util.MessageUtil;
import com.weixin.fastweixin.util.SignUtil;

/**
 * 将微信处理通用部分再抽象一层, 使用其他框架的同学可以自行继承此类集成微信
 * 
 * @author 	Lian
 * @date	2016年4月11日
 * @since	1.0	
 */
public abstract class WeixinSupport {
	private static final Logger LOG = LoggerFactory.getLogger(WeixinSupport.class);

	// 充当锁
	private static final Object LOCK = new Object();

	protected String fromUserName, toUserName;

	/**
	 * 微信消息处理器列表
	 */
	private static List<MessageHandle> messageHandles;

	/**
	 * 微信事件处理器列表
	 */
	private static List<EventHandle> eventHandles;

	/**
	 * 子类重写, 加入自定义的微信消息处理器, 细化消息的处理
	 *
	 * @return	微信消息处理器列表
	 */
	protected List<MessageHandle> initMessageHandles() {
		return null;
	}
	
	/**
	 * 子类重写, 加入自定义的微信事件处理器, 细化消息的处理
	 *
	 * @return
	 */
	protected List<EventHandle> initEventHandles() {
		return null;
	}
	
	/**
	 * 子类提供token用于绑定微信公众平台
	 *
	 * @return
	 */
	protected abstract String getToken();
	
	/**
	 * 公众号APPID, 使用消息加密模式时用户自行设置
	 *
	 * @return	微信公众平台提供的appid
	 */
	protected String getAppId() {
		return null;
	}
	
	/**
	 * 加密钥匙, 使用消息加密模式时用户自行设置
	 *
	 * @return
	 */
	protected String getAESKey() {
		return null;
	}
	
	/**
	 * 绑定服务器方法
	 *
	 * @param request	请求
	 * @param response	响应
	 */
	public void bindServer(HttpServletRequest request, HttpServletResponse response) {
		if(isLegal(request)) {
			try {
				PrintWriter pw = response.getWriter();
				pw.write(request.getParameter("echostr"));
				pw.flush();
				pw.close();
			} catch (Exception e) {
				LOG.error("绑定服务器异常", e);
			}
		}
	}
	
	
	public String processRequest(HttpServletRequest request) {
		Map<String, Object> reqMap = MessageUtil.parseXml(request, getToken(), getAppId(), getAESKey());
				
		return null;
	}
	
	protected boolean isLegal(HttpServletRequest request) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		return SignUtil.checkSignature(getToken(), signature, timestamp, nonce);
	}
}
