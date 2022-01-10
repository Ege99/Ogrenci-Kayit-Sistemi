package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.nodes.Tag;

import com.example.demo.entity.Student;
import com.example.demo.entity.Lesson;
import com.example.demo.repository.LessonRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class OgrenciKayitSistemi2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OgrenciKayitSistemi2Application.class, args);
	}
	
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private LessonRepository lessonRepository;
	
	@Override
	public void run(String... args) throws Exception {
		 
		
		Student student1 = new Student("Ege", "Subat");
		Student student2 = new Student("Hilmi", "Subat");

		
		Lesson lesson1 = new Lesson("Matematik");
		Lesson lesson2 = new Lesson("Fizik");
		
		student1.getLessons().add(lesson1);
		student1.getLessons().add(lesson2);
		
		lesson1.getStudents().add(student1);
		lesson2.getStudents().add(student1);
		
		lesson1.getStudents().add(student2);
		lesson2.getStudents().add(student2);
		
		student2.getLessons().add(lesson1);
		student2.getLessons().add(lesson2);
		
		this.studentRepository.save(student1);
		this.studentRepository.save(student2);

		
		
		/*
		Lesson lesson1 = new Lesson("Matematik");
		lessonRepository.save(lesson1);
		
		Lesson lesson2 = new Lesson("Türkçe");
		lessonRepository.save(lesson2);
		*/
		
		/*
		Student student1 = new Student("Ege", "Subat");
		studentRepository.save(student1);
		
		Student student2 = new Student("Hilmi", "Subat");
		studentRepository.save(student2);
		*/
		
		
	}

}
