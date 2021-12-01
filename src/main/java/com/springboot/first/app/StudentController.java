package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	// http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Shiv", "Maurya");
	}

	// Rest API which Returns list To the client
	// http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();
		students.add(new Student("Shiv", "Maurya"));
		students.add(new Student("Rishabh", "Singh"));
		students.add(new Student("Aman", "Maurya"));
		students.add(new Student("Amit", "Singh"));
		students.add(new Student("Somnath", "Vishwakarma"));
		return students;
	}

	// Rest API with Path Variable.
	// http://localhost:8080/student/Shiv/Maurya
	// @PathVariable Annotation
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);

	}

	// Build the Rest API to Handle Query Parameters
	// http://localhost:8080/student?firstName=Shiv&lastName=Maurya
	@GetMapping("/student/query")
	public Student studentQueryParam(@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName) {
		return new Student(firstName, lastName);
	}
}
