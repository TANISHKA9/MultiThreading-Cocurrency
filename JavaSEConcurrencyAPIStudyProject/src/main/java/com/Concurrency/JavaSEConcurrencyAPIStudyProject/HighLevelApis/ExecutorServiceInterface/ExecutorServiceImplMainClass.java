package com.Concurrency.JavaSEConcurrencyAPIStudyProject.HighLevelApis.ExecutorServiceInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author TA
 * 
 *         PseudoCode/Steps: 1. create bean for User with appropriate parameter
 *         as email, name, age. 2. create Db connection class with table to
 *         store user with name: ExecutorServiceUserDB 3. create UserDao class
 *         to store data into db. 4. create UserProcessor to process the user
 *         data using Callable class: Read row, parse it by (,) delimiter, map
 *         that data to user Object and pass it to dao class for saving into db.
 *         Then return the row count of number of rowsUpadated to calling
 *         function back to MainClass. 5. create database into mysql with name
 *         multithreadingconcurrency and table user with three columns email,
 *         name, age. 6. create ExecutorServiceImplMainClass to read file line
 *         by line and call executorService.submit to pass each line of record
 *         to
 *
 */
public class ExecutorServiceImplMainClass {

	public static void main(String[] args) {
		int numberOfRecordsInsertedSuccessfully = 0;
		List<String> userRecordList = readFile(
				"C:\\Users\\sonar\\git\\MultiThreading-Cocurrency\\JavaSEConcurrencyAPIStudyProject\\src\\main\\java\\Resources\\ExecutorServiceUserFile.txt");
		// ExecutorService executorService = Executors.newSingleThreadExecutor();  //Thread pool of single thread.
		// ExecutorService executorService = Executors.newFixedThreadPool(3); //Thread pool size is 3 here
		ExecutorService executorService = Executors.newCachedThreadPool();
		UserDao userDao = new UserDao();
		for (String user : userRecordList) {
			Future<Integer> future = executorService.submit(new UserProcessor(user, userDao));
			try {
				numberOfRecordsInsertedSuccessfully = numberOfRecordsInsertedSuccessfully + future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Total Number of Records Inserted in table are: " + numberOfRecordsInsertedSuccessfully);
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRecordsList;
	}

}
