package com.cogent.studentmanagementsystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private double credit;
	private String roomNum;
	@ManyToOne(targetEntity = Teacher.class)
	private Teacher teacher;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses")
	private List<Student> students;
	
	public Course(String courseName, double credit, String roomNum) {
		super();
		this.courseName = courseName;
		this.credit = credit;
		this.roomNum = roomNum;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		return this.courseId*1000;
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
}
