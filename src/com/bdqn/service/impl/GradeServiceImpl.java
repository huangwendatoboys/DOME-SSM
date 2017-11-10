package com.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.dao.GradeDao;
import com.bdqn.entity.Grade;
import com.bdqn.service.GradeService;

@Service("gradeService")
public class GradeServiceImpl implements GradeService {
	
	@Autowired//�Զ�װ��dao��
	private GradeDao gradeDao;
	
	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	@Override
	public List<Grade> getAll() {
		return gradeDao.getAllGrade();//����dao�㷽��
	}


}
