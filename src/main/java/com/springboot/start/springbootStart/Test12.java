package com.springboot.start.springbootStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test12 {

	public static void main(String[] args) {

		
		List<String> userNames = new ArrayList<String>() {{
		    add("Hollis");
		    add("Hollis");
		    add("hollis");
		    add("HollisChuang");
		    add("H");
		}};
		Iterator<String> iterator = userNames.iterator();
		
		while(iterator.hasNext()) {
			if (iterator.next().equals("Hollis")) {
	            iterator.remove();
	        }
		}
		
//		for (String string : userNames) {
//			 if (string.equals("Hollis")) { 
//				 userNames.remove(string);
//			}
//		}
		
//		for (int i = 0; i < userNames.size(); i++) {
//		    if (userNames.get(i).equals("Hollis")) {
//		        userNames.remove(i);
//		    }
//		}

		System.out.println(userNames);

////////////////////////////////////////
		
	}

}
