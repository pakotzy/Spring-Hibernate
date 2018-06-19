package com.pakotzy.springhibernate.rest.controllers;

import com.pakotzy.springhibernate.rest.exceptions.ExceptionResponse;
import com.pakotzy.springhibernate.rest.exceptions.StudentNotFoundException;
import com.pakotzy.springhibernate.rest.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students;

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable("studentId") Long studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}

		return students.get(studentId.intValue());
	}

	@PostConstruct
	public void populateData() {
		students = new ArrayList<>();

		students.add(new Student("Pavlo", "Kotelnytskyi"));
		students.add(new Student("Andrew", "Black"));
		students.add(new Student("Mario", "Rossi"));
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleStudentNotFoundException(StudentNotFoundException e) {
		ExceptionResponse error = new ExceptionResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
