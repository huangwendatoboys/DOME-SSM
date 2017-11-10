package com.bdqn.service;

import java.util.List;

import com.bdqn.entity.Pager;
import com.bdqn.entity.Student;

public interface StudentService {
	
	
	//����ѧ��
	public int addStudent(Student s);

	//����id��ѯ�޸�ǰ������
	public Student getStudentById(int sno);
		
	//�ύ���µ�ѧ����Ϣ
	public void updateStudent(Student s);
	
	//ɾ��ѧ����Ϣ
    public void deleteStudent(int sno);
    
    
    //��ѯѧ����Ϣ����������ҳ
  	public List<Student> getStudentByPager2(Student s,Pager pager);
}
