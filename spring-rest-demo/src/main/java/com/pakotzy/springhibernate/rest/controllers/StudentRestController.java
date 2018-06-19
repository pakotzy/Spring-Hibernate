package com.pakotzy.springhibernate.rest.controllers;

import com.pakotzy.springhibernate.rest.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students = new ArrayList<>();

	public StudentRestController() {
		students.add(new Student("Pavlo", "Kotelnytskyi"));
		students.add(new Student("Andrew", "Black"));
		students.add(new Student("Mario", "Rossi"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		return students.get(id.intValue());
	}
}
