package com.debatecontest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.debatecontest.model.Student;
import com.debatecontest.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	public StudentService studentService;

	@RequestMapping("/")
	public String retrieveStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("Students", students);
		return "home";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "register";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("studentId") int studentId, Model model) {
		Student student = studentService.findById(studentId);
		model.addAttribute("Student", student);
		return "register";
	}

	@RequestMapping("/save")
	public String save(@RequestParam("studentId") int studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student student = new Student();

		if (studentId != 0) {
			student = studentService.findById(studentId);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		} else {
			student = new Student(firstName, lastName, course, country);
		}

		studentService.save(student);
		return "redirect:/";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int studentId) {
		studentService.deleteById(studentId);
		return "redirect:/";
	}

}
