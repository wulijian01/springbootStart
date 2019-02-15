package com.springboot.start.springbootStart.dateUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	
	public static LocalDateTime convertLocalDateTime(LocalDateTime localDateTime) {
		
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format = localDateTime.format(ofPattern);
		
		return  LocalDateTime.parse(format, ofPattern);
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Date date = new Date();
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(date);
		
		c.add(Calendar.DATE, 1);
		
		System.out.println(c.getTime().toString());
	}

}
