package com.cogent.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.studentmanagementsystem.model.Course;
import com.cogent.studentmanagementsystem.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository cr;
	@Override
	public Course insertCourse(Course course) {
		// TODO Auto-generated method stub
		Course course1= cr.save(course);
		return course1;
	}

	@Override
	public Course updateCourseById(int id, Course course) {
		Optional<Course> course1 = cr.findById(id);
		if(course1.isPresent()) {
			Course s = course1.get();
			s.setCourseId(id);
			s.setCourseName(course.getCourseName());
			s.setCredit(course.getCredit());
			s.setRoomNum(course.getRoomNum());
			s.setStudents(course.getStudents());
			s.setTeacher(course.getTeacher());
			cr.save(s);
			return s;
		}
		else 
			return null;
	}

	@Override
	public void deleteCourse(int id) {
		Optional<Course> course1 = cr.findById(id);
		if(course1.isPresent()) {
			Course s = course1.get();
			cr.delete(s);
			
		}
		else {
			System.out.println("didnt find the course");
		}
		
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
	
		return cr.findAll();
	}

	@Override
	public Course getCourseById(int id) {
		Optional<Course> course1 = cr.findById(id);
		if(course1.isPresent()) {
			Course s = course1.get();
			return s;
			
		}
		else {
			System.out.println("didnt find the course");
			return null;
		}
	}

}
