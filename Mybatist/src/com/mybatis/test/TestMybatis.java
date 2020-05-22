package com.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis {

	public static void mainqueryOne() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		String sql="com.mybatis.test.StudentMapper.selectStudent";
		Student One = session.selectOne(sql,1);
		System.out.println(One);
		session.close();
	}
   
	public static void insertStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		String sql="com.mybatis.test.StudentMapper.insertStudent";
		Student stu=new Student(5,"sf",26);
		int One = session.insert(sql,stu );
		session.commit();
		System.out.println(One);
		session.close();
	}
	
    public static void updateStudent() throws IOException {
    	Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		String sql="com.mybatis.test.StudentMapper.updateStudent";
		
		Student stu=new Student();
		stu.setId(2);
		stu.setName("ef");
		stu.setAge(55);
		int One = session.update(sql, stu);
		session.commit();
		System.out.println(One);
		session.close();
	}
	
    public static void queryAll() throws IOException {
    	Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		String sql="com.mybatis.test.StudentMapper.selectAll";
		List<Student> One = session.selectList(sql);
		System.out.println(One);
		session.close();
	}
    public static void deleteStudent() throws IOException {
    	Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		String sql="com.mybatis.test.StudentMapper.deleteStudent";
		int One = session.delete(sql, 5);
		session.commit();
		System.out.println(One);
		session.close();
	}
	public static void main(String[] args) throws IOException {
		queryAll();
		//insertStudent();
		//deleteStudent();
		updateStudent();
		queryAll();
	}
}
