package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.AppConfig;
import com.klu.model.Order;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext cn = new AnnotationConfigApplicationContext(AppConfig.class);
		Order or = cn.getBean(Order.class);
		or.display();
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Order or1 =(Order) context.getBean(Order.class);
		or1.display();
	}
	
	

}
