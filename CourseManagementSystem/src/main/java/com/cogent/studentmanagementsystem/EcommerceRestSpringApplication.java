package com.cogent.studentmanagementsystem;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.cogent.studentmanagementsystem.model.Course;
import com.cogent.studentmanagementsystem.model.Student;
import com.cogent.studentmanagementsystem.service.CourseService;
import com.cogent.studentmanagementsystem.service.StudentService;

@SpringBootApplication

public class EcommerceRestSpringApplication implements CommandLineRunner{

	@Autowired
	private CourseService cs;
	@Autowired
	private StudentService ss;
	public static void main(String[] args) {
		 SpringApplication.run(EcommerceRestSpringApplication.class, args);


		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//	Course course =cs.getCourseById(1);
//	System.out.println(course.getCourseName());
//		Course course1 =cs.getCourseById(2);
//		Course course2 =cs.getCourseById(3);
//		Course course3 =cs.getCourseById(4);
//		Student student = ss.getStudentById(1);
////		Student student1 = ss.getStudentById(2);
////
////
//		student.getCourses().add(course);
//		student.getCourses().add(course1);
//		student.getCourses().add(course2);
//		course.getStudents().add(student);
//		course1.getStudents().add(student);
//		course2.getStudents().add(student);
////		
////		student1.getCourses().add(course2);
////		student1.getCourses().add(course3);
////		course2.getStudents().add(student1);
////		course3.getStudents().add(student1);
////		
//		System.out.println("..........");
//		System.out.println(student.getCourses().size());
////
//		ss.updateStudentById(1, student);
////		ss.updateStudentById(2, student1);
//	
//	Student student = new Student();
//	student = ss.getStudentById(1);
//	student.getCourses().remove(2);
//	ss.updateStudentById(1, student);
	
//	Course c = new Course();
//	c= cs.getCourseById(1);
//	Student student = new Student();
//	student =ss.getStudentById(2);
//	System.out.println(student.getCourses());
//	for(Course cs : student.getCourses()) {
//		System.out.println(cs.getCourseId());
//		System.out.println(cs.getCourseName());
//		System.out.println(cs.getCredit());
//		System.out.println(cs.hashCode());
//		System.out.println(cs.getRoomNum());
//		cs.getStudents().forEach(System.out::println);
//		System.out.println(c==cs);
//		System.out.println(cs.equals(c));
//		System.out.println("..........");
//	
//	}
//	
//	System.out.println("..................");
//	System.out.println(c.getCourseId());
//	System.out.println(c.getCourseName());
//	System.out.println(c.getCredit());
//	System.out.println(c.hashCode());
//	System.out.println(c.getRoomNum());
//	c.getStudents().forEach(System.out::println);
//	
//	System.out.println(".................");
//	System.out.println(student.getCourses().contains(c));
//	
////	student.getCourses().remove(c);
////	ss.updateStudentById(3,	 student);
//	c.getStudents().remove(student);
//	cs.updateCourseById(c.getCourseId(), c);
	}

}
