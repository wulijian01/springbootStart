package com.springboot.start.springbootStart.reflect;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

public class reflect {

	public static void main(String[] args) {
		
		//ReflectTest reflectTest = new ReflectTest();
		try {
			Class<?> cls = ReflectTest.class;
			Object o = cls.newInstance();
			Field nameF = cls.getDeclaredField("name");
			System.out.println(nameF.getName());
			nameF.setAccessible(true);
			String name=(String)nameF.get(o);
			System.out.println(name);
			nameF.set(o, "2345");
			System.out.println((String)nameF.get(o));
			
			
			Class<?> c = DataSourceBuilder.class;
			
			DataSource obj = DataSourceBuilder.create().build();

			Field f = c.getDeclaredField("DATA_SOURCE_TYPE_NAMES");

			f.setAccessible(true);

			String[] s = (String[]) f.get(obj);

			s[1] = "com.mchange.v2.c3p0.ComboPooledDataSource";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
