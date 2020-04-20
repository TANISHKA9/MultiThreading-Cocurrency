package HighLevelApis.ScheduledExecutorServiceInterface;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author TA
 * Application HouseKeeping job scheduled using ScheduledExecutorService Interfaces. 
 * The timestamp passed jobs should be deleted.
 * steps: 
 * Generate a folder: Resources.SampleFolderOfFIlesFOrSchedulerExecutorService folder.
 * Pick up the folder containing list of files : Resources.SampleFolderOfFIlesFOrSchedulerExecutorService. 
 * check the timestamp of each file and delete the files which has certain time passed timestamp.
 * 
 * 
 * Threre are two jobs here : one creates files at regular interval at given path, 
 * second job deletes file with regular interval.
 *
 */
public class ScheduledExecutorServiceInterfaceMainClass {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4); //scheduled job pool of 4 threads
		scheduledExecutorService.schedule(()->{System.out.println(Thread.currentThread().getName()+ ": Jobs are going to start next one second, Current time is: "+System.currentTimeMillis());} , 4, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleAtFixedRate(new FileCreatorCallableJob(), 5, 10, TimeUnit.SECONDS); //create file at regular fixed interval of 5seconds.
		scheduledExecutorService.scheduleWithFixedDelay(new FolderReaderRunnableService(), 5, 10, TimeUnit.SECONDS); //delete files at 1second interval.

	}

}
