package com.cogent.studentmanagementsystem.service;

import java.util.List;

import com.cogent.studentmanagementsystem.model.Student;

public interface StudentService {

	public Student insertStudent(Student student);
	public Student updateStudentById(int id,Student student);
	public void deleteStudent(int id);
	public List<Student> getStudents();
	public Student getStudentById( int id);
}
