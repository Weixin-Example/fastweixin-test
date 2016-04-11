package com.weixin.fastweixin.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 集合常用方法工具类
 * 
 * @author 	Lian
 * @date	2016年4月11日
 * @since	1.0	
 */
public class CollectionUtil {

	/**
	 * 此类不需要实例化
	 */
	private CollectionUtil() {
	}

	/**
	 * 判断集合是否为空
	 * null或者空集合都返回true
	 *
	 * @param collection	需要判断的集合
	 * @return				是否有值, null或者空集合都是返回true
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	/**
	 * 判断一个集合是否不为空
	 *
	 * @param collection	需要判断的集合
	 * @return				是否不为空
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return collection != null && !collection.isEmpty();
	}

	/**
	 * 创建一个空集合
	 *
	 * @param <T> 	泛型
	 * @return		集合对象
	 */
	public static <T> ArrayList<T> newArrayList() {
		return new ArrayList<T>();
	}

	/**
	 * 创建一个指定大小的集合
	 *
	 * @param initialCapacity	集合大小
	 * @param <T> 				泛型
	 * @return					集合对象
	 */
	public static <T> ArrayList<T> newArrayList(int initialCapacity) {
		return new ArrayList<T>(initialCapacity);
	}

	/**
	 * 创建一个有默认内容的集合
	 *
	 * @param <T> 	泛型
	 * @param ele	内容
	 * @return		集合对象
	 */
	public static <T> ArrayList<T> newArrayList(T... ele) {
		ArrayList list = null;
		if (null != ele && 0 != ele.length) {
			list = new ArrayList(ele.length);
			Collections.addAll(list, ele);
		}
		return list;
	}
}