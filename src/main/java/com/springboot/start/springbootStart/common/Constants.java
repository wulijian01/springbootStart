package com.springboot.start.springbootStart.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

import com.springboot.start.springbootStart.task.DelayTask;

import lombok.Data;



public class Constants {

	public static String b="123";
	public static final String a="123";
	public static final  BlockingQueue<DelayTask> queue=new DelayQueue<>();
	
}
