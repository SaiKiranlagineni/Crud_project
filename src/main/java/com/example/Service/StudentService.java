package com.example.Service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Student;
import com.example.Entity.StudentDTO;
import com.example.Repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository repository;
	
	public StudentDTO saveStudent(StudentDTO studentDTO)
	{
		Student student=new Student();
		BeanUtils.copyProperties(studentDTO, student);
		 repository.save(student);
		 BeanUtils.copyProperties(student, studentDTO);
		 return studentDTO;
	}
	
	public List<StudentDTO> getAllstudents()
	{
		 List<Student> studentList=repository.findAll();
		 List<StudentDTO> studentDTOs=new ArrayList<>();
		 for(Student student:studentList) 
		 {
			 StudentDTO studentDTO=new StudentDTO();
			 BeanUtils.copyProperties(student, studentDTO);
			 studentDTOs.add(studentDTO);
		 }
		return studentDTOs;
	}
	
	public StudentDTO getStudentById(Long id) 
	{
		Student student=repository.findById(id).get();
		StudentDTO studentDTO=new StudentDTO();
		BeanUtils.copyProperties(student, studentDTO);
        return studentDTO;
    }
	
	 public String deleteStudent(Long id)
	 {
	        repository.deleteById(id);
			return "deleted succesfully";
	 }
	
	
	
}