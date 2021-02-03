package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.StudentInfo;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, Integer>{

}
