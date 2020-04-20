package custom.ThreadFactoryInterface;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
	private static int counter=0;
	
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("Custom-Thread-"+ (++counter));
		System.out.println("Custom Thread is created in my factory: " + thread.getName());
		return thread;
	}

}
