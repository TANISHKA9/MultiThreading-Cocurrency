package HighLevelApis.ExecutorInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 
 * @author TA
 * Three threads are generated here using Executor Interface and each thread reads data from file 
 * Using runnable interface.
 *
 */
public class ReadFileUsingRunnableInterfaceWithExecutorInterface {

	public static void main(String[] args) {
		
		Runnable runnable = () -> {
			try(BufferedReader bufferedReader = new BufferedReader(new FileReader
					(new File("C:\\Users\\sonar\\git\\MultiThreading-Cocurrency\\JavaSEConcurrencyAPIStudyProject\\src\\main\\java\\Resources\\sample.txt")))) {
				
				String line = null;
				while((line=bufferedReader.readLine())!=null) {
					System.out.println(Thread.currentThread().getName()+ " readings line " + line);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Executor executor = Executors.newFixedThreadPool(3); //ThreadPool of three threads size will be created
		executor.execute(runnable); //each statement of executor
		executor.execute(runnable);
		executor.execute(runnable);
	}

}
