package com.sprmab.dao;

import java.util.List;

import com.sprmab.entity.Student;

public interface StudentMapper {

   void	insertStudent(Student student);
   
   List<Student> selectAll();
}
