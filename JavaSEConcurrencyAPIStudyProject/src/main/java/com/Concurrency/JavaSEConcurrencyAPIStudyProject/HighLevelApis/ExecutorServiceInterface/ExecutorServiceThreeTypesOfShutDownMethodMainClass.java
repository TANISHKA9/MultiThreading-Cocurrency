package com.Concurrency.JavaSEConcurrencyAPIStudyProject.HighLevelApis.ExecutorServiceInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceThreeTypesOfShutDownMethodMainClass {
	public static void main(String[] args) {
		int numberOfRecordsInsertedSuccessfully = 0;
		List<String> userRecordList = readFile(
				"C:\\Users\\sonar\\git\\MultiThreading-Cocurrency\\JavaSEConcurrencyAPIStudyProject\\src\\main\\java\\Resources\\ExecutorServiceUserFile.txt");
		// ExecutorService executorService = Executors.newSingleThreadExecutor();  //Thread pool of single thread.
		// ExecutorService executorService = Executors.newFixedThreadPool(3); //Thread pool size is 3 here
		ExecutorService executorService = Executors.newCachedThreadPool();
		UserDao userDao = new UserDao();
		
		List<Callable<Integer>> listOfCallable= new ArrayList<>();
		userRecordList.forEach(x -> listOfCallable.add(new UserProcessor(x, userDao)));
		
		try {
			Integer future = executorService.invokeAny(listOfCallable);
			System.out.println(future);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(executorService.shutdownNow());
//		executorService.shutdown();
//		try {
//			executorService.awaitTermination(5, TimeUnit.NANOSECONDS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			executorService.shutdownNow();
//		}
		System.out.println("ExecutorService is shutting down " + executorService.isShutdown()); //After getting first future result this statement will be executed.
		System.out.println("ExecutorService is Terminated " + executorService.isTerminated());
		
	}

	private static List<String> readFile(String fileName) {
		List<String> userRecordsList = new ArrayList<String>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(Thread.currentThread().getName() + " readings line " + line);
				userRecordsList.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return userRecordsList;
	}
}
