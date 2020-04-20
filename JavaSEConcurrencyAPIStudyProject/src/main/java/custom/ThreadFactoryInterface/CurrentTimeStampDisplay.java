package custom.ThreadFactoryInterface;

import java.util.concurrent.Callable;

public class CurrentTimeStampDisplay implements Callable<Long> {

	@Override
	public Long call() throws Exception {
		Long timeStamp = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + " Thread is catching current timestamp: " + timeStamp);
		return timeStamp;
	}
	
}
