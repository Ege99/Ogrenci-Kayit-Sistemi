package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lessonid;
	
	@Column(name = "lesson_name", nullable=false)
	private String lessonName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "lessons")
	private Set<Student> students = new HashSet<>();
	
	
	public Lesson() {
		
	}
	
	public Lesson(String lessonName) {
		super();
		this.lessonName = lessonName;
	}


	
	public Set<Student> getStudents() {
		return students;
	}



	public void setStudents(Set<Student> students) {
		this.students = students;
	}



	public Long getLessonid() {
		return lessonid;
	}


	public void setLessonid(Long lessonid) {
		this.lessonid = lessonid;
	}


	public String getLessonName() {
		return lessonName;
	}


	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	
	
	
	
	
	
}
