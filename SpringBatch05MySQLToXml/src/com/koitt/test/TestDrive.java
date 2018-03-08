package com.koitt.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDrive {
	
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/koitt/config/applicationContext.xml");
		
		JobLauncher launcher = context.getBean(JobLauncher.class);
		Job job = context.getBean("mySqlToXmlJob", Job.class);
		
		try {
			// Builder Pattern 이런패턴이 많음
			JobParameters param = new JobParametersBuilder()
					.addString("age", "20") //나이가 20살 초반인사람만 xml로 출력이됨
					.toJobParameters();
			
			JobExecution execution = launcher.run(job, param);
			System.out.println("종료 상태: " + execution.getStatus());
			System.out.println("종료 상태: " + execution.getAllFailureExceptions());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("작업 완료!");
	}
}
