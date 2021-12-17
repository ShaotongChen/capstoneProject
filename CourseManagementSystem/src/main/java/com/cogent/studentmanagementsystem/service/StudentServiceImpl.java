package com.cogent.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.studentmanagementsystem.model.Student;
import com.cogent.studentmanagementsystem.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository sr;
	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		Student student1= sr.save(student);
		return student1;
	}

	@Override
	public Student updateStudentById(int id, Student student) {
		Optional<Student> student1 = sr.findById(id);
		if(student1.isPresent()) {
			System.out.println(id);
			Student s = student1.get();
			s.setStudentNumber(student.getStudentNumber());
			s.setStudentName("ddd");
			s.setGender(student.getGender());
			s.setCourses(student.getCourses());
			sr.save(s);
			return s;
		}
		else 
			return null;
	}

	@Override
	public void deleteStudent(int id) {
		Optional<Student> student1 = sr.findById(id);
		if(student1.isPresent()) {
			Student s = student1.get();
			sr.delete(s);
			
		}
		else {
			System.out.println("didnt find the student");
		}
		
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
	
		return sr.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> student1 = sr.findById(id);
		if(student1.isPresent()) {
			Student s = student1.get();
			return s;
			
		}
		else {
			System.out.println("didnt find the student");
			return null;
		}
	}

}
