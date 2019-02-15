package com.springboot.start.springbootStart.task;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DelayQueueProducer implements Runnable {
		
	 	private BlockingQueue<DelayTask> queue;
	    private Integer delayOfEachProducedMessageMilliseconds;

	@Override
	public void run() {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("123");
		Map<String,Set<String>> hashMap = new HashMap<>();
		hashMap.put("003", hashSet);
		
		
			  DelayTask object
	              = new DelayTask(
	            		  hashMap , delayOfEachProducedMessageMilliseconds);
	            System.out.println("Put object: " + object);
	            try {
	                queue.put(object);
	                Thread.sleep(500);
	            } catch (InterruptedException ie) {
	                ie.printStackTrace();
	            }
	}

}
