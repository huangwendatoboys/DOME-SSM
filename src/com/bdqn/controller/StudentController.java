package com.bdqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.entity.Grade;
import com.bdqn.entity.Pager;
import com.bdqn.entity.Student;
import com.bdqn.service.GradeService;
import com.bdqn.service.StudentService;

@Controller("test")
@RequestMapping("/") 
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired//
	private GradeService gradeService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}


	
	@RequestMapping("toAdd.do")
	
	public String toAdd(Model model){
		List<Grade> gradeList=gradeService.getAll();
		model.addAttribute("gradeList", gradeList);
		return "add";
		
	}
	
	@RequestMapping("doAdd.do")
	
	public String doAdd(Student student){
		int sid=studentService.addStudent(student);
		return "redirect:/getAll.do";
		
	}
	
	@RequestMapping("toUpdate/{sno}")
	
	public String toUpdate(@PathVariable int sno,Model model){
		
		Student oldStudent=studentService.getStudentById(sno);
		
		List<Grade> gradeList=gradeService.getAll();
		model.addAttribute("oldStudent", oldStudent);
		model.addAttribute("gradeList", gradeList);
		
		return "update";	
	}
	
	@RequestMapping("doUpdate.do")
	
	public String doUpdate(Student student){
		studentService.updateStudent(student);
		return "redirect:/getAll.do";	
	}
	
	
	@RequestMapping("doDelete/{sno}")
	public String doDelete(@PathVariable int sno){
		studentService.deleteStudent(sno);
		return "redirect:/getAll.do";	
	}
	
	
	@RequestMapping("getAll.do")
	public String getAll2(Student stu,Pager pager,Model model){
		System.out.println(stu.getSname());
		model.addAttribute("list", studentService.getStudentByPager2(stu,pager));
		model.addAttribute("pager",pager);
		model.addAttribute("stu",stu);
		return "select2";
	}

}
