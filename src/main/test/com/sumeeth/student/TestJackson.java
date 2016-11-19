/**
 * 
 */
package com.sumeeth.student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import com.sumeeth.model.Student;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class TestJackson {
	File jsonFile = new File("src/test/res/json/student.json");
	Student student;
	ObjectMapper mapper;

	@Test
	public void testJacksonForStudent() throws JsonGenerationException,
			JsonMappingException, IOException {

		mapper = new ObjectMapper();
		student = new Student(1, "sumeeth", "kanojia", 2, 2);
		String jsonString = mapper.writeValueAsString(student);
		Student studentFromJson = mapper.readValue(jsonString, Student.class);
		System.out.println(jsonString);
		Assert.assertEquals("Student ID Not Matched", 1,
				studentFromJson.getStudentId());
		Assert.assertEquals("Student FirstName Not Matched", "sumeeth",
				studentFromJson.getFirstname());
		Assert.assertEquals("Student LastName Not Matched", "kanojia",
				studentFromJson.getLastname());
		Assert.assertEquals("Student YearLevel Not Matched", 2,
				studentFromJson.getYearLevel());
		Assert.assertEquals("Student College ID Not Matched", 2,
				studentFromJson.getCollegeId());
	}

	@Test
	public void testJacksonForStudentList() throws JsonGenerationException,
			JsonMappingException, IOException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		mapper = new ObjectMapper();
		student = new Student(1, "sumeeth", "kanojia", 2, 2);
		for (int i = 0; i < 5; i++)
			studentList.add(student);
		String jsonString = mapper.writeValueAsString(studentList);
		FileUtils.writeStringToFile(jsonFile, jsonString);
		jsonString = FileUtils.readFileToString(jsonFile);
		studentList = mapper.readValue(jsonString, ArrayList.class);
		Assert.assertEquals(5, studentList.size());
	}

}
