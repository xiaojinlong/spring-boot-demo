package net.azalea.springbootaoplog.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Json 转化工具�?
 *
 * @package: com.xkcoding.springbootdemoaoplog.util
 * @description：Json 转化工具�?
 * @author: yangkai.shen
 * @date: Created in 2017/11/24 上午9:36
 * @copyright: Copyright (c) 2017
 * @version: 0.0.1
 * @modified: yangkai.shen
 */
@Slf4j
public class JsonMapper {
	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 对象�? json 字符�?
	 *
	 * @param src 元对�?
	 * @param <T> 类型
	 * @return json 字符�?
	 */
	public static <T> String obj2Str(T src) {
		if (src == null) {
			return null;
		}
		try {
			return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
		} catch (IOException e) {
			log.error("【JSON 转换：对�? --> 字符串�?�，异常堆栈：{}", e);
			return null;
		}
	}

	/**
	 * json 字符串转化为对象
	 *
	 * @param src           �? json 字符�?
	 * @param typeReference 转化后的类型
	 * @param <T>           类型
	 * @return 返回转化后的对象
	 */
	public static <T> T str2Obj(String src, TypeReference<T> typeReference) {
		if (src == null || typeReference == null) {
			return null;
		}
		try {
			return (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
		} catch (Exception e) {
			log.error("【JSON 转换：字符串 --> 对象】，异常堆栈：{}", e);
			return null;
		}
	}
}
