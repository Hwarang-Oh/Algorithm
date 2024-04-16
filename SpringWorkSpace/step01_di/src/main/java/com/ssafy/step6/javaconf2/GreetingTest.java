package com.ssafy.step6.javaconf2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GreetingConfig.class);
		GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
		greetingService.sayHello("소수빈");
	}

}
