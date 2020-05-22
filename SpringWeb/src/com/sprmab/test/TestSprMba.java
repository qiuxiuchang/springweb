package com.sprmab.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sprmab.entity.Student;
import com.sprmab.service.StudentService;
import com.sprmab.service.impl.StudentServiceImpl;

public class TestSprMba {

	public static void main(String[] args) {
	ApplicationContext context = new	ClassPathXmlApplicationContext("applicationContext.xml");
	StudentService service  =   (StudentServiceImpl)context.getBean("studentServiceImpl");
	List<Student> queryStudent = service.queryStudent();
	
	System.out.println(queryStudent);
	}
}
