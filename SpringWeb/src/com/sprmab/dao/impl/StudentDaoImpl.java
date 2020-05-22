package com.sprmab.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sprmab.dao.StudentMapper;
import com.sprmab.entity.Student;

public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentMapper{

	@Override
	public void insertStudent(Student student) {
	  
		SqlSession sqlSession = super.getSqlSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		mapper.insertStudent(student);
		
	}

	@Override
	public List<Student> selectAll() {
		SqlSession sqlSession = super.getSqlSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentall = mapper.selectAll();
		return studentall;
	}

}
