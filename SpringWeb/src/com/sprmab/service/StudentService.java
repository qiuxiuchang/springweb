package com.sprmab.service;

import java.util.List;

import com.sprmab.entity.Student;

public interface StudentService {

	 void addStudent(Student stu);
	 List<Student> queryStudent();
}
