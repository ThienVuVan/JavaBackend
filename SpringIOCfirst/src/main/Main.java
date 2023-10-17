package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Employee;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		// Employee em1 = context.getBean(Employee.class);
		Employee em1 = (Employee) context.getBean("em1");
		Employee em2 = (Employee) context.getBean("em2");
		System.out.println(em1);
		System.out.println(em2);
//		Employee em = context.getBean(Employee.class);
//		System.out.println(em);

	}

}
