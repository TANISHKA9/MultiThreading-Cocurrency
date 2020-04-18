package com.Concurrency.JavaSEConcurrencyAPIStudyProject.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author TA
 * This Class works to read data from file using three threads using runnable interface parallel.
 *
 */
public class ReadFileUsingRunnableInterface{
	
	public static void main(String[] args) {
		Runnable runnable = () -> {
			try(BufferedReader bufferedReader = new BufferedReader(new FileReader
					(new File("C:\\Users\\sonar\\Documents\\workspace-sts-3.9.8.RELEASE\\JavaSEConcurrencyAPIStudyProject\\src\\main\\java\\Resources\\sample.txt")))) {
				
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
		
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		t1.start();
		t2.start();
		t3.start();
	}
}
