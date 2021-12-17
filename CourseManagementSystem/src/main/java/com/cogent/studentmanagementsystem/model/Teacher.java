package com.cogent.studentmanagementsystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String teacherName;
	private String emailId;
	private long phone;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "teacherId")
	private List<Course> courses;
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.teacherId*100;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this.hashCode()==obj.hashCode())
		return true;
		else return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.teacherName;
	}
}
