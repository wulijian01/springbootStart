package com.springboot.start.springbootStart.task;

import java.util.concurrent.BlockingQueue;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DelayQueueConsumer implements Runnable {

	private BlockingQueue<DelayTask> queue;
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DelayTask poll = queue.poll();
			if (poll!=null) {
				
				System.out.println("----------"+poll.getModifiedOpcos().get("003"));
			}else {
				System.out.println("000");
			}
		}

	}

}
