package com.springboot.start.springbootStart.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.springboot.start.springbootStart.common.Constants;


public class Test001 {

	
	public static void test() {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
//		BlockingQueue<DelayTask> queue = new DelayQueue<>();
		
		DelayQueueConsumer consumer = new DelayQueueConsumer(Constants.queue);
		
		DelayQueueProducer producer = new DelayQueueProducer(Constants.queue, 10000);
		
		executor.execute(producer);
		
		executor.execute(consumer);
	}
	
	public static void main(String[] args) {
		test();
	}
}
