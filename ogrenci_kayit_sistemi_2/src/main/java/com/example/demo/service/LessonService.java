package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Lesson;

public interface LessonService {
	List<Lesson> getAllLessons();
	
	Lesson saveLesson(Lesson lesson);
	
	Lesson getLessonById(Long lessonid);
	
	Lesson updateLesson(Lesson lesson);
	
	void deleteLessonById(Long lessonid);
}
