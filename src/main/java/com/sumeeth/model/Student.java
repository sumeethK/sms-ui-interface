package com.sumeeth.model;

public class Student {
	// for autonumber
	private int studentId;
	private String firstname;
	private String lastname;
	private int yearLevel;
	private int collegeId;

	public Student() {
	}

	public Student( int studentId,String firstname, String lastname, int yearLevel,int collegeId) {
		super();
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearLevel = yearLevel;
		this.collegeId = collegeId;

	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

	/**
	 * @return the collegeId
	 */
	public int getCollegeId() {
		return collegeId;
	}

	/**
	 * @param collegeId
	 *            the collegeId to set
	 */
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String toString() {
		return "firstname:" + firstname + " lastname :" + lastname
				+ " collegeId:" + collegeId;
	}
}
