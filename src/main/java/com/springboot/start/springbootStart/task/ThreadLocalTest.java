package com.springboot.start.springbootStart.task;


public class ThreadLocalTest {
	 String name;
	    
	    
	    private final ThreadLocal<String> tLocal = new ThreadLocal<>();
	    
		public  void addRecord(String arg) {
			name = arg;
			
			new Thread(()->{
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tLocal.set(arg);
				System.out.println(Thread.currentThread().getName()+":"+tLocal.get());
				
			}).start();
					
			System.out.println(name);
		}
		
		public static void main(String[] args) {
			ThreadLocalTest test1 = new ThreadLocalTest();
			
			test1.addRecord("2");
			test1.addRecord("3");
			
		}
}
