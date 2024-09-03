package com.kh.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.hello.MessageBean;
import com.kh.hello.MessageBeanI;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new MessageBean().sayHello("김창호");
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
		MessageBeanI bean = (MessageBean)ctx.getBean("messageBean");
		bean.sayHello("엄은지");
	}

}
