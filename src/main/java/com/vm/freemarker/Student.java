package com.vm.freemarker;

import java.util.List;

public class Student {
	Integer id;
	String firstName;
	String lastName;
	List<Score> examScores;
	
	public Student(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		examScores = null;
	}
	
	public Integer getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public List<Score> getExamScores() {
		return examScores;
	}
	public void setExamScores(List<Score> examScores) {
		this.examScores = examScores;
	}  

}
