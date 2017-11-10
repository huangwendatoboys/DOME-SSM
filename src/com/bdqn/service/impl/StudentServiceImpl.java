package com.bdqn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.dao.StudentDao;
import com.bdqn.entity.Pager;
import com.bdqn.entity.Student;
import com.bdqn.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired//�Զ�װ��dao��
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public int addStudent(Student s) {
		studentDao.addStudent(s);
		return s.getSno();//��������ѧ��
	}

	//����id��ѯ�޸�ǰ������
	public Student getStudentById(int sno){
		return studentDao.getStudentById(sno);
	}
		
	//�ύ���µ�ѧ����Ϣ
	public void updateStudent(Student s){
		studentDao.updateStudent(s);
	}
	
	//ɾ��ѧ����Ϣ
	public void deleteStudent(int sno){
		studentDao.deleteStudent(sno);
	}
	
	
	@Override//����ѯ�����ķ�ҳ
	public List<Student> getStudentByPager2(Student s,Pager pager) {
		int n=studentDao.getStudentByCount2(s);
		pager.setTotalCounts(n);
		Map<String,Object> map=new HashMap<String,Object> ();
		//ͨ��HashMap��sqlӳ���ļ�����ҳ����Ϣ
		map.put("pageOffset", (pager.getCurrPage()-1)*pager.getPageSize());//���������
		map.put("pageSize",pager.getPageSize());//ÿҳ��С
		map.put("student",s);//��ѯ����
		return studentDao.getStudentByPager2(map);
	}
}
