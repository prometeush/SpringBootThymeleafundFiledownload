package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.StudentInfoRepository;
import com.project.entity.StudentInfo;

@Service
public class StudentInfoService {
	
	@Autowired
	private StudentInfoRepository repository1;
	
	public List<StudentInfo> listStudentInfo(){
		List<StudentInfo> list=repository1.findAll();
		return list;
	}
	 public void saveStudentInfo(StudentInfo student) {
		 this.repository1.save(student);
	 }
	 
	 public void deletestudentInfo(Integer id) {
		 this.repository1.deleteById(id);
	 }
	 
	 public StudentInfo findByIdStudentInfo(Integer id) {
		 StudentInfo student=repository1.findById(id).get();
		 return student;
	 }
	 
	 public void updateStudentInfo(StudentInfo student) {
		 this.repository1.save(student);
	 }

}
