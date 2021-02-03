package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "studentinfo")
public class StudentInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String vorname;
	
	@NotBlank
	private String nachname;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String prog_sprache;
	
	@NotBlank
	private String gender;
	
	public StudentInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentInfo(Integer id, String vorname, String nachname, String email, String prog_sprache, String gender) {
		
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.prog_sprache = prog_sprache;
		this.gender = gender;
	}
	public StudentInfo(String vorname, String nachname, String email, String prog_sprache, String gender) {
	
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.prog_sprache = prog_sprache;
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProg_sprache() {
		return prog_sprache;
	}
	public void setProg_sprache(String prog_sprache) {
		this.prog_sprache = prog_sprache;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
