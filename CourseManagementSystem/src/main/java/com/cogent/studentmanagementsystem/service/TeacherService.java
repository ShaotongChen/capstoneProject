package com.cogent.studentmanagementsystem.service;

import java.util.List;

import com.cogent.studentmanagementsystem.model.Teacher;

public interface TeacherService {

	public Teacher insertTeacher(Teacher teacher);
	public Teacher updateTeacherById(int id,Teacher teacher);
	public void deleteTeacher(int id);
	public List<Teacher> getTeachers();
	public Teacher getTeacherById( int id);
}
