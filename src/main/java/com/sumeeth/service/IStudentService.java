package com.sumeeth.service;

import java.util.List;

import com.sumeeth.model.Student;

public interface IStudentService {
	void add(Student student);

	void edit(Student student);

	void delete(int studentId);

	Student getStudent(int studentId);

	List getAllStudent();

	List<Student> getStudentByFirstName(String studentFirstName);

	List<Student> getStudentByLastName(String studentFirstName);

	List<Student> getStudentByCollegeId(int collegeId);

	List<Student> getStudentByYearLevel(int yearLevel);
}
