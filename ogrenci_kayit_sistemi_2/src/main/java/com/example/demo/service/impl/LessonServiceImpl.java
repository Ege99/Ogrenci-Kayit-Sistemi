package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Lesson;
import com.example.demo.repository.LessonRepository;
import com.example.demo.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

	private LessonRepository lessonRepository;
	
	
	
	public LessonServiceImpl(LessonRepository lessonRepository) {
		super();
		this.lessonRepository = lessonRepository;
	}



	@Override
	public List<Lesson> getAllLessons() {
		
		return lessonRepository.findAll();
	}



	@Override
	public Lesson saveLesson(Lesson lesson) {
		return lessonRepository.save(lesson);
	}



	@Override
	public Lesson getLessonById(Long lessonid) {
		return lessonRepository.findById(lessonid).get();
	}



	@Override
	public Lesson updateLesson(Lesson lesson) {
		return lessonRepository.save(lesson);
	}



	@Override
	public void deleteLessonById(Long lessonid) {
		lessonRepository.deleteById(lessonid);
		
	}

}
