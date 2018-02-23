package com.vm.freemarker;

import java.util.List;

public class Score {
    String subject;
    Integer score;
    
    List<Grader> graders;

	public Score(String subject, int score) {
		this.subject = subject;
		this.score = score;
		graders = null;
	}

	public String getSubject() {
		return subject;
	}

	public Integer getScore() {
		return score;
	}
	
	public List<Grader> getGraders() {
		return graders;
	}

	public void setGraders(List<Grader> graders) {
		this.graders = graders;
	}
	
	

}
