package com.cogent.studentmanagementsystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentNumber; 
	private String studentName;
	private String gender;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_course",
			joinColumns = @JoinColumn(name="student_number"),
	inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Course> courses;

	public Student(String studentName, String gender) {
		super();
		this.studentName = studentName;
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.studentNumber;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this.hashCode()==obj.hashCode())
			return true;
		else {
			return false;
		
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.studentName;
	}
}
