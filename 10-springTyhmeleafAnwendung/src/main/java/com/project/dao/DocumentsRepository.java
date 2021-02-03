package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Documents;

public interface DocumentsRepository extends JpaRepository<Documents, Integer>{

}
