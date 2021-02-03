package com.project.control;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.StudentInfo;
import com.project.service.StudentInfoService;

@Controller
public class StudentInfoController {
	
	@Autowired
	public StudentInfoService service1;
	
	@RequestMapping("/")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/studentinfo")
	public String studentList(Model model) {
		List<StudentInfo> list=service1.listStudentInfo();
		model.addAttribute("studentlist", list);
		return "student-info";
	}
	
	@RequestMapping("/studentform")
	public String studentForm(Model model) {
		model.addAttribute("studentmodel", new StudentInfo());
		List<String> list1=Arrays.asList("Java","JavaFX","JSP","JSF","Thymeleaf","Spring Boot","Spring MVC"
				,"JavaScript","Angular 10","jQuery","Bootstrap 4","HTML5","CSS3");
		model.addAttribute("programmierunglist", list1);
		return "student-form";
	}
	
	@RequestMapping("/studentSave")
	public String studentSave(@Valid @ModelAttribute("studentmodel")StudentInfo student,BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<String> list1=Arrays.asList("Java","JavaFX","JSP","JSF","Thymeleaf","Spring Boot","Spring MVC"
					,"JavaScript","Angular 10","jQuery","Bootstrap 4","HTML5","CSS3");
			model.addAttribute("programmierunglist", list1);
			return "student-form";
		}else {
			if(student.getId()!=null) {
				this.service1.updateStudentInfo(student);
			}else {
				this.service1.saveStudentInfo(student);
			}
		}
		
		return "redirect:/studentinfo";
	}
	
	@RequestMapping("/delete/{id}")
	public String studentDelete(@PathVariable("id") Integer id) {
		this.service1.deletestudentInfo(id);		
		return "redirect:/studentinfo";
	}
	
	@RequestMapping("/update/{id}")
	public String studentUpdate(@PathVariable("id") Integer id,Model model) {
		StudentInfo student=this.service1.findByIdStudentInfo(id);
		model.addAttribute("studentmodel",student);
		List<String> list1=Arrays.asList("Java","JavaFX","JSP","JSF","Thymeleaf","Spring Boot","Spring MVC"
				,"JavaScript","Angular 10","jQuery","Bootstrap 4","HTML5","CSS3");
		model.addAttribute("programmierunglist", list1);
		return "student-form";
	}
	

}
