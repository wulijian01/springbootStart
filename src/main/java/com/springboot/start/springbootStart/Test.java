package com.springboot.start.springbootStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.omg.PortableServer.ServantActivator;

import com.springboot.start.springbootStart.common.Constants;

import afu.org.checkerframework.checker.units.qual.s;


public class Test {
	
	private static final String b="123123";
	private static final Map m =new HashMap<>();

//	private static RuntimeSchema<UserVo> schema = RuntimeSchema.createFrom(UserVo.class);

	private static final String [] a = {"123","234","789"};
	
	private static final String [] c= {"su","m","t","w","th","f","sa"};
	
	public static void main(String[] args) {
		
//		List<String> list = new ArrayList<>();
//		
//		String b="0 0  0 ";
//		
//		IntStream.range(0, b.length()).forEach(i ->{
//			
//			if ("0".equals(String.valueOf(b.charAt(i)))) {
//				list.add(c[i]);
//			}
//		});
//
//		System.out.println(list);
//		System.out.println("1233");
		
		
//		String s="12";
//		s="23";
//		System.out.println(s);
		
//		b="343"; error
//		m.put("12", "你好");ok
		
//		String s1 = "疯狂JAVA";     
//	    String s2 = "疯狂" + "JAVA";     
//	    System.out.println( s1 == s2 );  //true     
//	    String str1 = "疯狂";     
//	    String str2 = "JAVA";     
//	    String s3 = str1 + str2;     
//	    System.out.println( s1 == s3 );  //false     
//	         
//	    final String fs1 = "疯狂";     
//	    final String fs2 = "JAVA";     
//	    String s4 = fs1 + fs2;     
//	    System.out.println( s1 == s4 );  //true
		
//		UserVo build = UserVo.builder().password("123").username("admin").build();
//		
//		System.out.println(build);
		
//		List<Object> list = new ArrayList<>();
//		List<String> collect = list.stream().map(a ->
//			
//			a+"123"
//		).collect(Collectors.toList());
//		System.out.println(collect);
//		boolean anyMatch = collect.stream().anyMatch("y"::equals);
//		System.out.println(anyMatch);
		
		
//		String a = Constants.a;
//		String a1 = Constants.a;
//		System.out.println(a);
//		a="123";
//		a=new String("123");
		
//		System.out.println(a==a1);
		
//		List<String> names = Arrays.asList("bob", "josh", "megan");
//		names.forEach(name ->System.out.println(name.toUpperCase()));
//		names.replaceAll(name -> name.toUpperCase());
//		System.out.println(names.toString());
		
//		List<Integer> list = Arrays.asList(1,2,3,4,3,2,5,6,4);
		
		
//		List<Integer> collect = list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
//		System.out.println(collect.toString());
		
//		List<UserVo> list = new ArrayList<>();
//		UserVo userVo = new UserVo();
//		UserVo userVo1 = new UserVo();
//		userVo.setPassword("122");
//		userVo.setUsername("zs");
//		userVo1.setPassword("123");
//		userVo1.setUsername("zr");
//		list.add(userVo);
//		list.add(userVo1);
//		
//		List<UserVo> collect = list.stream().sorted((o1,o2) ->{
//			int compareTo = o1.getPassword().compareTo(o2.getPassword());
//			if (compareTo==0) {
//			compareTo=o1.getUsername().compareTo(o2.getUsername());
//		}
//			return compareTo;
//		}).collect(Collectors.toList());
		
//		List<UserVo> collect = list.stream().distinct().sorted(new Comparator<UserVo>() {
//			@Override
//			public int compare(UserVo o1, UserVo o2) {
//				int compareTo = o1.getPassword().compareTo(o2.getPassword());
//				if (compareTo==0) {
//					compareTo=o1.getUsername().compareTo(o2.getUsername());
//				}
//				return compareTo;
//			}
//		}.reversed()).collect(Collectors.toList());
//		System.out.println(collect.toString());
		
//		list.stream().filter(new Predicate<Integer>() {
//
//			@Override
//			public boolean test(Integer arg0) {
//				
//				return arg0>6;
//			}
//		}).forEach(System.out::println);
		
//		list.stream().filter(n ->{
//			return n>3;
//		}).forEach(System.out::println);
		
/**
 * 序列化
 */
		
//		UserVo userVo = new UserVo();
//		userVo.setPassword("123");
//		userVo.setUsername("zs");
//		
//		byte[] userVoByte = ProtostuffIOUtil.toByteArray(userVo, schema, 
//				LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
//		System.out.println(userVoByte.toString());
//		
//		
//		UserVo userVo2 = schema.newMessage();
//		ProtostuffIOUtil.mergeFrom(userVoByte, userVo2, schema);
//		System.out.println(userVo2.getPassword());
//		a[0]="456";
//		Arrays.sort(a, Comparator.naturalOrder());
//		System.out.println(Arrays.toString(a));
		
		
		List<String> arrayList = new ArrayList<String>() {
			{
				add("1");
				add("2");
			}
		} ;
	
		List<String> list = new ArrayList<>();
		
//		Collections.copy(arrayList, list);
		
		list.addAll(arrayList);
		
		System.out.println(list);
		
		System.out.println("123344");
	}


}
