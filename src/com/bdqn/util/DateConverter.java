package com.bdqn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * SpringMVC����ת����
 * @author weishi
 *
 */
public class DateConverter implements Converter<String,Date>{

	private SimpleDateFormat[] sdf=
			{new SimpleDateFormat("yyyy-MM-dd"),
			 new SimpleDateFormat("yyyy/MM/dd"),
			 new SimpleDateFormat("yyyy��MM��dd��")
			};
	
	@Override
	public Date convert(String str) {
		for (int i = 0; i < sdf.length; i++) {
			try{
				return sdf[i].parse(str);
			}catch(Exception ex){
				continue;
			}
		}
		return null;
	}

}
