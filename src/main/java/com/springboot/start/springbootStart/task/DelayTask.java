package com.springboot.start.springbootStart.task;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import com.google.common.primitives.Ints;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DelayTask implements Delayed{
	
	private Map<String,Set<String>> modifiedOpcos;
	private long delayTime;
	 
    public DelayTask(Map<String,Set<String>> modifiedOpcos, long delayTime) {
        this.modifiedOpcos = modifiedOpcos;
        this.delayTime = System.currentTimeMillis() + delayTime;
    }

	@Override
	public int compareTo(Delayed another) {
		return Ints.saturatedCast(
			      this.delayTime - ((DelayTask) another).delayTime);
    }
	
	@Override
	public long getDelay(TimeUnit timeUnit) {
		long difference = delayTime - System.currentTimeMillis();
        return timeUnit.convert(difference, TimeUnit.MILLISECONDS);
	}

	
}
