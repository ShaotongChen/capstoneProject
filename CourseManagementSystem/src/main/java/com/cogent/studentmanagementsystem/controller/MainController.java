package com.cogent.studentmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cogent.studentmanagementsystem.model.Course;
import com.cogent.studentmanagementsystem.model.Student;
import com.cogent.studentmanagementsystem.model.Teacher;
import com.cogent.studentmanagementsystem.service.CourseService;
import com.cogent.studentmanagementsystem.service.StudentService;
import com.cogent.studentmanagementsystem.service.TeacherService;

@Controller
public class MainController {
	
	@Autowired
	CourseService cs;
	@Autowired
	StudentService ss;
	@Autowired
	TeacherService ts;
	//home page
	@GetMapping("/")
	public String home() {
	
		return "home";
	}
	@GetMapping("/Course")
	public String CoursesPage(Model m) {
		List<Course> courses= cs.getCourses();
		m.addAttribute("courses", courses);
		
		return"coursePage";
	}
	@GetMapping("/Teacher")
	public String TeacherPage(Model m) {
		List<Teacher> teachers= ts.getTeachers();
		m.addAttribute("teachers", teachers);
		return"teacherPage";
	}
	@GetMapping("/Student")
	public String StudentPage(Model m) {
		List<Student> students= ss.getStudents();
		m.addAttribute("students", students);
		return"studentPage";
	}
	//end of home page

	//insert page
	@GetMapping("/NewCourse")
	public String NewCoursePage(Model m) {
		Course course = new Course();
		m.addAttribute("course", course);
		return "NewCoursePage";
	}
	@GetMapping("/NewStudent")
	public String NewStudent( Model m) {
		Student s= new Student();
		m.addAttribute("student", s);
		return "NewStudentPage";
	}
	@GetMapping("/NewTeacher")
	public String NewTeacher (Model m) {
		Teacher teacher = new Teacher();
		m.addAttribute("teacher", teacher);
		return "NewTeacherPage";
	}
	//end of insert page
	//insert part
	@PostMapping("/saveStudent")
	public String saveStudent(@RequestParam String name, @RequestParam String gender) {
		Student student = new Student();
		student.setStudentName(name);
		student.setGender(gender);
		ss.insertStudent(student);
		System.out.println(name);
	
		return "redirect:/Student";
	}
	@PostMapping("/saveStudent1")
	public String saveStudent1(@ModelAttribute("student") Student student) {

		ss.insertStudent(student);
		return "redirect:/Student/"+student.getStudentNumber();
	}
	@PostMapping("/saveTeacher1")
	public String saveTeacher1(@ModelAttribute("teacher") Teacher teacher) {
		
		ts.insertTeacher(teacher);
		return "redirect:/Teacher/"+teacher.getTeacherId();
	}
	@PostMapping("/saveCourse1")
	public String saveCourse1(@ModelAttribute("course") Course course) {
		
		cs.insertCourse(course);
		return "redirect:/Course/"+course.getCourseId();
	}
	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute Teacher teacher) {
		ts.insertTeacher(teacher);
		return "redirect:/Teacher";
	}
	@PostMapping("/saveCourse")
	public String saveCourse(@ModelAttribute Course course) {
		cs.insertCourse(course);
		return "redirect:/Course";
	}
	// end of insert part
	//certain unit
	@GetMapping("/Course/{id}")
	public String SpecialCoursePage(Model m, @PathVariable(value = "id")int id) {
		Course c = cs.getCourseById(id);
		m.addAttribute("course", c);
		List<Student> s=c.getStudents();
		m.addAttribute("students", s);
		Teacher t = c.getTeacher();
		m.addAttribute("teacher", t);
		return "CourseID";
		
	}
	@GetMapping("/Student/{id}")
	public String SpecialStudentPage(Model m, @PathVariable(value = "id") int id) {
		Student s= ss.getStudentById(id);
		m.addAttribute("student", s);
		return "StudentID";
	}
	@GetMapping("/Teacher/{id}")
	public String SpecialTeacherPage(Model m, @PathVariable(value = "id") int id) {
		Teacher t= ts.getTeacherById(id);
		List<Course> courses = t.getCourses();
		m.addAttribute("teacher", t);
		m.addAttribute("courses",courses);
		
		return "teacherID";
	}
	//end of certain unit
	//delete
	@GetMapping("/Course/delete/{id}")
	public String deleteCourse(@PathVariable(value="id") int id) {
		cs.deleteCourse(id);
		return "redirect:/Course";
	}
	@GetMapping("/Student/delete/{id}")
	public String deleteStudent(@PathVariable(value = "id") int id) {
		ss.deleteStudent(id);
		return "redirect:/Student";
	}
	@GetMapping("/Teacher/delete/{id}")
	public String deleteTeacher(@PathVariable(value = "id") int id) {
		ts.deleteTeacher(id);
		return "redirect:/Teacher";
	}
	@GetMapping("/Student/delete/Course/{id}")
	public String deleteCourseofStudent(@PathVariable(value="id") int id, @RequestParam String courseId) {
		int cid= Integer.parseInt(courseId);
		Student student = ss.getStudentById(id);
		Course course = cs.getCourseById(cid);
		
		student.getCourses().remove(course);
		ss.updateStudentById(id, student);
		return "redirect:/Student/"+student.getStudentNumber();
	}
	@GetMapping("/Course/delete/Student/{id}")
	public String deleteStudentofCourse(@PathVariable(value="id") int id, @RequestParam String studentId) {
		int sid= Integer.parseInt(studentId);
		Student student = ss.getStudentById(sid);
		Course course = cs.getCourseById(id);
		int index=course.getStudents().indexOf(student);
	student.getCourses().remove(course);
	ss.updateStudentById(sid, student);
		return "redirect:/Course/"+id;
	}
	//update
	@GetMapping("/Course/update/{id}")
	public String UpdateCoursePage(@PathVariable(value = "id")int id, Model m) {
		Course course = cs.getCourseById(id);
		m.addAttribute("course", course);
		return "updateCoursePage";
		
	}
	@GetMapping("/Teacher/update/{id}")
	public String UpdateTeacgerPage(@PathVariable(value = "id")int id, Model m) {
		Teacher teacher = ts.getTeacherById(id);
		m.addAttribute("teacher", teacher);
		return "updatePage";
		
	}
	@GetMapping("/Student/update/{id}")
	public String UpdateStudenPage(@PathVariable(value = "id")int id, Model m) {
		Student student =ss.getStudentById(id);
		m.addAttribute("student", student);
		return "updateStudentPage";
		
	}
//end of update
	@GetMapping("/Student/addCourse/{id}")
	public String addCourseForm(@PathVariable(value = "id") int id,Model m) {
		Student s= ss.getStudentById(id);
		List<Course> courses= cs.getCourses();
		m.addAttribute("courses", courses);
		m.addAttribute("student", s);
		return "checkCoursePage";
		
		
	}
	@GetMapping("/Course/addStudent/{id}")
	public String addStudentForm(@PathVariable(value = "id") int id, Model m) {
		Course c = cs.getCourseById(id);
		List<Student> students = ss.getStudents();
		m.addAttribute("students", students);
		m.addAttribute("course", c);
		return "checkStudentPage";
		
	}
	@GetMapping("/Teacher/addCourse/{id}")
	public String addTCourseForm(@PathVariable(value = "id") int id, Model m) {
		Teacher t= ts.getTeacherById(id);
		List<Course> courses= cs.getCourses();
		m.addAttribute("courses", courses);
		m.addAttribute("teacher", t);
		return "checkTeacherCoursePage";
		
	}
	@PostMapping("/Student/addCourse/{id}")
	public String addCourseToStudent(@PathVariable(value = "id") int id,@RequestParam String courseId) {
		Student student = ss.getStudentById(id);
		int cid= Integer.parseInt(courseId);
		Course course = cs.getCourseById(cid);
		for (Course cour : student.getCourses()) {
			if(cour==course) {
				return "redirect:/Student/"+id;
				
			}
		}
		student.getCourses().add(course);
		course.getStudents().add(student);
		
		ss.updateStudentById(student.getStudentNumber(), student);
		
		return "redirect:/Student/"+id;
	}
	@PostMapping("/Teacher/addCourse/{id}")
	public String addCourseToTeacher(@PathVariable(value = "id") int id,@RequestParam String courseId) {
		Teacher teacher = ts.getTeacherById(id);
		int cid= Integer.parseInt(courseId);
		Course course = cs.getCourseById(cid);
		for (Course cour : teacher.getCourses()) {
			if(cour==course) {
				return "redirect:/Teacher/"+id;
				
			}
		}
		teacher.getCourses().add(course);
		course.setTeacher(teacher);
		
		ts.updateTeacherById(teacher.getTeacherId(), teacher);
		
		return "redirect:/Teacher/"+id;
	}
		@PostMapping("/Course/addStudent/{id}")
		public String addStudentToCourse(@PathVariable(value = "id") int id,@RequestParam String studentId) {
		Course c = cs.getCourseById(id);
			int sid= Integer.parseInt(studentId);
			Student student = ss.getStudentById(sid);
			for (Student st : c.getStudents()) {
				if(st==student) {
					return "redirect:/Course/"+id;
					
				}
			}

		student.getCourses().add(c);
		c.getStudents().add(student);
	
		cs.updateCourseById(c.getCourseId(), c);
		
		return "redirect:/Course/"+id;
		
	}
	
}

