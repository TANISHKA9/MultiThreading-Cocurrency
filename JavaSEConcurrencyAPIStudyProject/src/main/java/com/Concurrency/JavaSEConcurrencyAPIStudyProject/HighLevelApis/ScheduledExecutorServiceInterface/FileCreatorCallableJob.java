package com.Concurrency.JavaSEConcurrencyAPIStudyProject.HighLevelApis.ScheduledExecutorServiceInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class FileCreatorCallableJob implements Runnable{

	@Override
	public void run() {
		Path path = Paths.get("C:\\Users\\sonar\\git\\MultiThreading-Cocurrency\\JavaSEConcurrencyAPIStudyProject\\src\\main\\java\\Resources\\SampleFolderOfFilesForSchedulerExecutorService\\file"+ System.currentTimeMillis()+".txt");
		Path catchPath = null;
		try {
			catchPath = Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!catchPath.toString().isEmpty()) {
			System.out.println(Thread.currentThread().getName()+": file is created : "+ catchPath.getFileName());
		}
	}
}
