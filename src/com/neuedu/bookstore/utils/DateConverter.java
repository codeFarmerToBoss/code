package com.neuedu.bookstore.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/*
 * 自定义类型转换器
 * 		1、编写一个类实现类型转换接口
 * 		2.实现类型转换方法
 * 		3、修改mvc配置，配置类型转换器
 * 
 * 
 */

public class DateConverter implements Converter<String, Date>  {

	@Override
	public Date convert(String input) {	//编写时间转换器，支持多种时间格式转换
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		if (input != null) {
			
			try {
				return simpleDateFormat.parse(input);
			} catch (ParseException e) {	//使用新格式重新转换
				pattern = "yyyy/MM/dd";
				simpleDateFormat.applyPattern(pattern);
				try {
					return simpleDateFormat.parse(input);
				} catch (ParseException e1) {
					pattern = "yyyy-MM-dd HH:mm:ss";
					simpleDateFormat.applyPattern(pattern);
					try {
						return simpleDateFormat.parse(input);
					} catch (ParseException e2) {
						return new Date();
					}
				}
			}
		} else {
			return new Date();
		}
		
	}

	
}
