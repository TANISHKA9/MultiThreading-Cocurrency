package com.Concurrency.JavaSEConcurrencyAPIStudyProject.HighLevelApis.ScheduledExecutorServiceInterface;

import java.io.File;
import java.util.List;

public class FolderReaderRunnableService implements Runnable{

	@Override
	public void run() {
		File folder = new File("C:\\Users\\sonar\\git\\MultiThreading-Cocurrency\\JavaSEConcurrencyAPIStudyProject\\src\\main\\java\\Resources\\SampleFolderOfFilesForSchedulerExecutorService");
		File[] listOfFile = folder.listFiles();
		for(File file:listOfFile) {
			if(System.currentTimeMillis() - file.lastModified() > (1*60*1000)) {
				System.out.println(Thread.currentThread().getName()+": Deleting the file: "+ file.getName());
				file.delete();
			}
		}
	}

}
