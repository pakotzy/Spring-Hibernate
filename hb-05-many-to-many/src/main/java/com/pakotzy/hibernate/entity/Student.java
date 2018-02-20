package com.pakotzy.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn
			(name = "course_id"))
	private List<Course> courses;

	public Student(){}

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public void addCourse(Course... course) {
		if (courses == null) {
			courses = new ArrayList<>();
		}

		courses.addAll(Arrays.asList(course));
	}

	public List<Course> getCourses() {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		return courses;
	}

	@Override
	public String toString() {
		return "Student{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", courses=" + courses.stream().map(Course::getTitle).collect(Collectors.joining("; ")) +
				'}';
	}
}
