package com.example.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.StudentDTO;
import com.example.Service.StudentService;



@RestController
@RequestMapping("/student")
public class StudentController
{
	@Autowired
	private StudentService service;
	
	@PostMapping("/signup")
	public ResponseEntity<StudentDTO> savedstudent(@RequestBody StudentDTO studentDTO)
	{
		return new ResponseEntity<StudentDTO>(service.saveStudent(studentDTO),HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<List<StudentDTO>> getallstudents()
	{
		return ResponseEntity.ok(service.getAllstudents());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getstudent(@PathVariable("id") Long id)
	{
		return ResponseEntity.ok(service.getStudentById(id));
	}
	
	@PutMapping
	public ResponseEntity<StudentDTO> updatestudent(@RequestBody StudentDTO studentDTO)
	{
		return new ResponseEntity<>(service.saveStudent(studentDTO),HttpStatus.CREATED);
	}
	
	 @DeleteMapping("/{id}")
	  public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id)
	 {
	    service.deleteStudent(id);
	    return ResponseEntity.noContent().build();
	 }
	
	
	
	

}