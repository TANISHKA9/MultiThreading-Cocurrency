package custom.ThreadFactoryInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CustomThreadFactoryMainClass {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3, new CustomThreadFactory());
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new CustomThreadFactory());
		scheduledExecutorService.scheduleAtFixedRate(()->{Future<Long> future = executorService.submit(new CurrentTimeStampDisplay());}, 5, 5, TimeUnit.SECONDS);
		
	}

}
