package com.cogent.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.studentmanagementsystem.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
