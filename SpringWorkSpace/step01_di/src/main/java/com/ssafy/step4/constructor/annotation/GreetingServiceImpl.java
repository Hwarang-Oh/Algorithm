package com.ssafy.step4.constructor.annotation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Scope("prototype")
@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter; // 의존객체

//	@Autowired
	public GreetingServiceImpl(OutputService outputter) { // 생성자 DI
		System.out.println("GreetingServiceImpl(OutputService outputter)...");
		this.outputter = outputter;
	}
	@Override
	public void sayHello(String name) {
		try {
			outputter.output("Hello "+name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
