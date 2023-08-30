package com.app.gaz.sbrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.gaz.sbrestapi.model.Student;

@RestController
@RequestMapping("students")
public class StudentController {

	@GetMapping("student")
	public ResponseEntity<Student>  getStudent() {

		Student student = new Student(1, "Fco", "Gaz");

		//return new ResponseEntity(student, HttpStatus.OK);
		//return ResponseEntity.ok(student);
		return ResponseEntity.ok()
				.header("customer-header", "e-book")
				.body(student);
	}

	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {

		List<Student> students = new ArrayList<>();

		students.add(new Student(1, "Fco", "Gaz"));
		students.add(new Student(2, "Pablo", "Guzman"));
		students.add(new Student(3, "Julio", "Arias"));

		//return students;
		return ResponseEntity.ok()
				.header("customer-header-list", "e-book")
				.body(students);
	}

	@GetMapping("{id}")
	public Student studentPathStudent(@PathVariable("id") int id) {
		return new Student(id, "Leo", "Ayala");

	}

//http://localhost:8080/students-names/1/fco/gaz ---> @PathVariable
	@GetMapping("{id}/{firstName}/{lastName}")
	public Student studentPathNames(@PathVariable("id") int studentId,
			@PathVariable("firstName") String studentfirstName, @PathVariable("lastName") String studentlastName) {
		return new Student(studentId, studentfirstName, studentlastName);
	}

//http://localhost:8080/student/query?id=422&firstName=Qro&lastName=Mex->@RequestParam 
	@GetMapping("query")
	public Student studentRequestvariable(@RequestParam int id) {
		return new Student(id, "Navojoa", "Son");
	}

	@GetMapping("allquery")
	public Student studentRequestvariable2(@RequestParam int id, String firstName, String lastName) {
		return new Student(id, firstName, lastName);
	}
	
	@PostMapping("create")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	@DeleteMapping("{id}/delete")
	//@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String>deleteStudent (@PathVariable("id")int studentId) {
		System.out.println(studentId);
		return ResponseEntity.ok("Studente Delete Successfully !!! ");
	}
	

}
