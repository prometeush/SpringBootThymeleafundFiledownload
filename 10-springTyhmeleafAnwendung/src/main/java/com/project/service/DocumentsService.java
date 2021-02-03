package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.DocumentsRepository;
import com.project.entity.Documents;

@Service
public class DocumentsService {
	
	@Autowired
	private DocumentsRepository repository2;
	
	public List<Documents> listDocuments(){
		List<Documents> list=repository2.findAll();
		return list;
	}
	 public void saveDocuments(Documents document) {
		 this.repository2.save(document);
	 }

}
