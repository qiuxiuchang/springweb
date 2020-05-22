package com.mybatis.test;

public class Student {

	private int id;    //学生学号
	private String name;//学生姓名
	private int age; //学生姓名
	
	public Student() {//无参构造方法
		super();
	
	}
	public Student(int id, String name, int age) {//我要修改有参构造方法
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {//学号的getidfangfa
		return id;
	}
	public void setId(int id) {//学号的set方法
		this.id = id;
	}
	public String getName() {//学生名字的get方法
		return name;
	}
	public void setName(String name) {//学set方法
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
