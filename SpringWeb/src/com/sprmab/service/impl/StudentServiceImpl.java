package com.sprmab.service.impl;

import java.util.List;

import com.sprmab.dao.StudentMapper;
import com.sprmab.entity.Student;
import com.sprmab.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentMapper studentmapper;
	
	
	public void setStudentmapper(StudentMapper studentmapper) {
		this.studentmapper = studentmapper;
	}

	@Override
	public void addStudent(Student stu) {
		
		
	}
	
    public List<Student> queryStudent() {
    	return studentmapper.selectAll();
		
	}

	
}
