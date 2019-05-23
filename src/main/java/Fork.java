import java.util.concurrent.RecursiveTask;

/**
 * 
 * 递归二分求和
 *
 */
public class Fork extends RecursiveTask<Long>{

	private long[] number;
	
	private int start;
	
	private int end;
	
	private static final long THRESHOLD= 3;
	
	public Fork(long[] number) {
		this(number, 0, number.length);
	}
	
	public Fork(long[] number, int start, int end) {
		this.number = number;
		this.start = start;
		this.end = end;
	}



	@Override
	protected Long compute() {
		
		int length=end-start;
		
		if (length<=THRESHOLD) {
			
			return computetest();
		}
		
		Fork fork = new Fork(number,start,start+length/2);
		
		fork.fork();
		
		Fork fork1 = new Fork(number,start+length/2,end);
		Long result1 = fork1.compute();
		Long result = fork.join();
		
		return result+result1;
	}
	
	
	
	private long computetest() {
		
		long sum =0;
		
		for (int i = start; i < end; i++) {
			sum+=number[i];
		}
		return sum;
	}

}
