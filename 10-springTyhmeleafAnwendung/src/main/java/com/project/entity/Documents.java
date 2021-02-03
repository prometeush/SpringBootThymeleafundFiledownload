package com.project.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Documents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private byte[]content;
	
	private long size;
	
	private Date upload_time;
	
	public Documents() {
		// TODO Auto-generated constructor stub
	}

	public Documents(Integer id, String name, byte[] content, long size, Date upload_time) {
		
		this.id = id;
		this.name = name;
		this.content = content;
		this.size = size;
		this.upload_time = upload_time;
	}

	public Documents(String name, byte[] content, long size, Date upload_time) {
		
		this.name = name;
		this.content = content;
		this.size = size;
		this.upload_time = upload_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getUpload_time() {
		return upload_time;
	}

	public void setUpload_time(Date upload_time) {
		this.upload_time = upload_time;
	}
	
	

}
