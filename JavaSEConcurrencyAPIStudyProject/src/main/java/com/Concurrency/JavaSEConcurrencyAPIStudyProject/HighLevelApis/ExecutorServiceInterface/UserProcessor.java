package com.Concurrency.JavaSEConcurrencyAPIStudyProject.HighLevelApis.ExecutorServiceInterface;

import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserProcessor implements Callable<Integer>{
	private String userRecord;
	private UserDao userDao;

	@Override
	public Integer call() throws Exception {
		User user;
		int numberOfRowsUpdates = 0;
		System.out.println(Thread.currentThread().getName() + 
				" Thread is processing records for :" + userRecord);
		StringTokenizer stringTokenizer = new StringTokenizer(userRecord,",");
		while(stringTokenizer.hasMoreTokens()) {
			user = new User();
			user.setEmail(stringTokenizer.nextToken());
			user.setName(stringTokenizer.nextToken());
			user.setAge(Integer.valueOf(stringTokenizer.nextToken()));
			numberOfRowsUpdates = userDao.saveUser(user);
			if(numberOfRowsUpdates>0)
			System.out.println("Save is done! for user: " + user);
		}
		return numberOfRowsUpdates;
	}
}
