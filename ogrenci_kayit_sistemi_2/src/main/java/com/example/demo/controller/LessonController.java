package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Lesson;
import com.example.demo.service.LessonService;

@Controller
public class LessonController {
	
	private LessonService lessonService;

	public LessonController(LessonService lessonService) {
		super();
		this.lessonService = lessonService;
	}
	
	// handler method to handle list lessons and return model and view
	@GetMapping("/lessons") // gidilecek sayfa localhost:8080/lessons
	public String listLessons(Model model) {
		model.addAttribute("lessons", lessonService.getAllLessons());
		return "lessons"; // templates/lessons.html
	}
	
	@GetMapping("/lessons/new")
	public String createLessonForm(Model model) {
		
		// create lesson object to hold lesson form data
		Lesson lesson = new Lesson();
		model.addAttribute("lesson", lesson);
		return "create_lesson";
		
	}
	
	@PostMapping("/lessons")
	public String saveLesson(@ModelAttribute("lesson") Lesson lesson) {
		lessonService.saveLesson(lesson);
		return "redirect:/lessons"; // 23. satira doner
	}
	
	@GetMapping("/lessons/edit/{lessonid}")
	public String editLessonForm(@PathVariable Long lessonid, Model model) {
		model.addAttribute("lesson", lessonService.getLessonById(lessonid));
		return "edit_lesson";
	}
	
	
	@PostMapping("/lessons/{lessonid}")
	public String updateLesson(@PathVariable Long lessonid,
			@ModelAttribute("lesson") Lesson lesson,
			Model model) {
		
		// get lesson from database by id 
		Lesson existingLesson = lessonService.getLessonById(lessonid);
		existingLesson.setLessonid(lessonid);
		existingLesson.setLessonName(lesson.getLessonName());
		
		// save updated lesson object
		lessonService.updateLesson(existingLesson);
		return "redirect:/lessons";
		
	}
	
	
	// handler method to handle delete lesson request
	@GetMapping("/lessons/{lessonid}")
	public String deleteLesson(@PathVariable Long lessonid) {
		lessonService.deleteLessonById(lessonid);
		return "redirect:/lessons";
	}
	
}
