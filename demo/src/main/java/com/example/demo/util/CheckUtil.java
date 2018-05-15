package com.example.demo.util;

import com.example.demo.exceptions.CheckException;

import java.util.stream.Stream;

/**
 * @author: lcc
 * @Date: 2018-05-15
 **/
public class CheckUtil {

	private static final String[] INVALID_NAMES = {"admin", "guanliyuan"};

	/**
	 * 校验名字, 不成功抛出校验异常
	 *
	 * @param value
	 */
	public static void checkName(String value) {
		Stream.of(INVALID_NAMES).filter(name -> name.equalsIgnoreCase(value))
				.findAny().ifPresent(name -> {
			throw new CheckException("name", value);
		});
	}

}
