/**
 * 
 */
package com.sumeeth.student;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sumeeth.model.College;
import com.sumeeth.model.Student;
import com.sumeeth.service.IStudentService;

/**
 * @author sumeeth kumar kanojia
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-spring-servlet.xml" })
@Configurable
public class StudentTest {
	private Student student;
	private College college;
	@Autowired
	private IStudentService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		college = new College();
		college.setName("IIT KGP");
		college.setCity("Kharagpure");
		student = new Student(0, "Rohit", "Sharma", 4, 0);
	}

	@Ignore
	@Test
	public void testAddStudentWithoutCollegeId() {
		service.add(student);
	}

	@Test
	public void testGetStudentByFirstName() {
		List<Student> studentList = service
				.getStudentByFirstName("rohit");
		System.out.println(studentList.get(0));
	}

}
