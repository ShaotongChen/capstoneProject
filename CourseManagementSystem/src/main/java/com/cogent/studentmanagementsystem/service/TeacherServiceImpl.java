package com.cogent.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.studentmanagementsystem.model.Teacher;
import com.cogent.studentmanagementsystem.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherRepository tr;
	@Override
	public Teacher insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Teacher teacher1= tr.save(teacher);
		return teacher1;
	}

	@Override
	public Teacher updateTeacherById(int id, Teacher teacher) {
		Optional<Teacher> teacher1 = tr.findById(id);
		if(teacher1.isPresent()) {
			Teacher t = teacher1.get();
			t.setTeacherName(teacher.getTeacherName());
			t.setEmailId(teacher.getEmailId());
			t.setPhone(teacher.getPhone());
			t.setCourses(teacher.getCourses());
			tr.save(t);
			return t;
		}
		else 
			return null;
	}

	@Override
	public void deleteTeacher(int id) {
		Optional<Teacher> teacher1 = tr.findById(id);
		if(teacher1.isPresent()) {
			Teacher s = teacher1.get();
			tr.delete(s);
			
		}
		else {
			System.out.println("didnt find the teacher");
		}
		
	}

	@Override
	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
	
		return tr.findAll();
	}

	@Override
	public Teacher getTeacherById(int id) {
		Optional<Teacher> teacher1 = tr.findById(id);
		if(teacher1.isPresent()) {
			Teacher s = teacher1.get();
			return s;
			
		}
		else {
			System.out.println("didnt find the teacher");
			return null;
		}
	}

}
