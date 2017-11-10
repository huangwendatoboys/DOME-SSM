package com.bdqn.dao;

import java.util.List;
import java.util.Map;

import com.bdqn.entity.Student;

public interface StudentDao {
	
	public void addStudent(Student s);
	
	public Student getStudentById(int sno);
	
	public void updateStudent(Student s);
	
	public void deleteStudent(int sno);
	
	
	public int getStudentByCount2(Student s);
	
	public List<Student> getStudentByPager2(Map map);
	

}
