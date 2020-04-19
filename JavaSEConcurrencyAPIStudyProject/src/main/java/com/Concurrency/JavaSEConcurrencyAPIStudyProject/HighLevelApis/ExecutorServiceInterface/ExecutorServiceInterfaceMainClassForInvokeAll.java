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

public class ExecutorServiceInterfaceMainClassForInvokeAll {
	public static void main(String[] args) {
		int numberOfRecordsInsertedSuccessfully = 0;
		List<String> userRecordList = readFile(
				"C:\\Users\\sonar\\git\\MultiThreading-Cocurrency\\JavaSEConcurrencyAPIStudyProject\\src\\main\\java\\Resources\\ExecutorServiceUserFile.txt");
		// ExecutorService executorService = Executors.newSingleThreadExecutor();  //Thread pool of single thread.
		// ExecutorService executorService = Executors.newFixedThreadPool(3); //Thread pool size is 3 here
		ExecutorService executorService = Executors.newCachedThreadPool();
		UserDao userDao = new UserDao();
		List<Callable<Integer>> ListOfCallable= new ArrayList<>();
		
		for(String user:userRecordList) {
			ListOfCallable.add(new UserProcessor(user, userDao));
		}
		
		try {
			List<Future<Integer>> futures = executorService.invokeAll(ListOfCallable);
			futures.forEach(i->{
				try {
					System.out.println(i.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executorService.shutdown();
		System.out.println("Operation Completed and ExecutorService is shutting down");
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
