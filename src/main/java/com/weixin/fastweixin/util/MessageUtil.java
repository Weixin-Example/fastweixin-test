package com.weixin.fastweixin.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * 消息工具类
 * 用于解析微信平台消息xml报文
 * 
 * @author 	Lian
 * @date	2016年4月11日
 * @since	1.0	
 */
public final class MessageUtil {

	private static final Logger LOG = LoggerFactory.getLogger(MessageUtil.class);
	
	private static final String FORMAT = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

	/**
	 * 此类不需要实例化
	 */
	private MessageUtil() {
	}
	
	public static Map<String, Object> parseXml(HttpServletRequest request, String token, String appId, String aesKey) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		InputStream inputStream = null;
		try {
			inputStream = request.getInputStream();
			if(StrUtil.isNotBlank(aesKey)) {
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				StreamUtil.copy(inputStream, outputStream);
				String body = outputStream.toString();
				LOG.debug("收到的消息密文:{}", body);
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				StringReader sr = new StringReader(body);
				InputSource is = new InputSource(sr);
				Document document =  db.parse(is);
				
				Element root = document.getDocumentElement();
				NodeList nodeList1 = root.getElementsByTagName("Encrypt");
				
//				WXB
			}
		} catch (Exception e) {
			
		}
		return null;
	}
}
