package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students request and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
				
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{studentid}")
	public String editStudentForm(@PathVariable Long studentid, Model model) {
		
		model.addAttribute("student", studentService.getStudentById(studentid));
		return "edit_student";
		}
	
	@PostMapping("/students/{studentid}")
	public String updateStudent(@PathVariable Long studentid,
			@ModelAttribute("student")Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(studentid);
		existingStudent.setStudentid(studentid);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";

	}
	
	// handler method to handle delete student request
	
	@GetMapping("/students/{studentid}")
	public String deleteStudent(@PathVariable Long studentid) {
		studentService.deleteStudentById(studentid);
		return "redirect:/students";
	}

	
	
	
}










