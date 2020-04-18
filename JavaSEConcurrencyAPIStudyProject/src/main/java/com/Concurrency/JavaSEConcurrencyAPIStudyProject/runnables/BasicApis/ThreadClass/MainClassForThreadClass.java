package com.Concurrency.JavaSEConcurrencyAPIStudyProject.runnables.BasicApis.ThreadClass;

/**
 * 
 * @author TA
 * This class reads the data from file using Thread class using three different threads parallel
 *
 */

public class MainClassForThreadClass {

	public static void main(String[] args) {
		ReadFileUsingThreadClass t1 = new ReadFileUsingThreadClass();
		ReadFileUsingThreadClass t2 = new ReadFileUsingThreadClass();
		ReadFileUsingThreadClass t3 = new ReadFileUsingThreadClass();
		
		t1.start();
		t2.start();
		t3.start();

	}

}
