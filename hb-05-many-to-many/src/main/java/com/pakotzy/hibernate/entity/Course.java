package com.pakotzy.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn
			(name = "student_id"))
	private List<Student> students;

	public Course(){}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review... review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}

		reviews.addAll(Arrays.asList(review));
	}

	public void addStudent(Student... student) {
		if (students == null) {
			students = new ArrayList<>();
		}

		students.addAll(Arrays.asList(student));
	}

	public List<Student> getStudents() {
		if (students == null) {
			students = new ArrayList<>();
		}
		return students;
	}

	@Override
	public String toString() {
		return "Course{" +
				"\n\ttitle='" + title + '\'' +
				"\n\treviews=" + reviews.stream().map(Review::getComment).collect(Collectors.joining("\n\t\t")) +
				'}';
	}
}
