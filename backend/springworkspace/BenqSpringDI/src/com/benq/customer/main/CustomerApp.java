package com.benq.customer.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.benq.customer.domain.CustomerVO;
import com.benq.customer.service.CustomerService;
import com.benq.customer.service.impl.CustomerServiceImpl;

public class CustomerApp {
	public static void main(String[] args) {
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
//		CustomerService cService = new CustomerServiceImpl();
		CustomerService cService = (CustomerServiceImpl)ctx.getBean("customerService");
		List<CustomerVO> cList = cService.selectList();
		if(!cList.isEmpty()) {
			for(CustomerVO customer : cList) {
				System.out.println(customer.toString());
			}
		}
	}
}
