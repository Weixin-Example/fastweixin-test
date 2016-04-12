package com.weixin.fastweixin.company.message.req;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年4月12日
 * @since	1.0	
 */
public class QYSendPicInfoEvent extends QYMenuEvent {

	private int count;
	private List<Map> picList;

	public QYSendPicInfoEvent(String eventKey, int count, List<Map> picList) {
		super(eventKey);
		this.count = count;
		this.picList = picList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Map> getPicList() {
		return picList;
	}

	public void setPicList(List<Map> picList) {
		this.picList = picList;
	}

	@Override
	public String toString() {
		return "QYMenuEvent [count=" + count + ", picList=" + picList + ", eventKey=" + getEventKey() + ", toUserName=" + toUserName
				+ ", fromUserName=" + fromUserName + ", createTime=" + createTime + ", msgType=" + msgType + ", event=" + event + ", agentId="
				+ agentId + "]";
	}
}
