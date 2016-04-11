package com.weixin.fastweixin.api.config;

import java.io.Serializable;
import java.util.Observable;

/**
 * API配置类, 项目中保证其为单例
 * 实现观察者模式, 用于监控token变化
 * 
 * @author 	Lian
 * @date	2016年3月8日
 * @since	1.0	
 */
public class ApiConfig extends Observable implements Serializable{

	private static final long serialVersionUID = -4594730549017708832L;
//	private static final Logger        LOG             = LoggerFactory.getLogger(ApiConfig.class);
//	private static final Logger LOG = LoggerFactory.getLogger(ApiConfig.class);

}
