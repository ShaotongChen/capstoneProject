package com.cogent.studentmanagementsystem.service;

import java.util.List;

import com.cogent.studentmanagementsystem.model.Course;

public interface CourseService {

	public Course insertCourse(Course course);
	public Course updateCourseById(int id,Course course);
	public void deleteCourse(int id);
	public List<Course> getCourses();
	public Course getCourseById( int id);
}
