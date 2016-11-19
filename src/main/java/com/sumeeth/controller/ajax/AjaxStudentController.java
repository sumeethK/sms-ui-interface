package com.sumeeth.controller.ajax;

import com.sumeeth.model.Student;
import com.sumeeth.service.ICollegeService;
import com.sumeeth.service.IStudentService;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sumeeth kumar kanojia
 *This class is meant to serve ajax request for student.
 */
@Controller
public class AjaxStudentController {
	private IStudentService studentService;
	private ICollegeService collegeService;
	
	@RequestMapping(value = "/getStudentByFirstName", method = RequestMethod.GET)
	@ResponseBody
	public  String getStudentByFirstName(@RequestParam("request") String action){
		ObjectMapper mapper = new ObjectMapper();
		List<Student> studentList = studentService.getStudentByFirstName(action);
		String jsonInString="";
		try {
			jsonInString = mapper.writeValueAsString(studentList);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonInString;
	}
	@RequestMapping(value = "/getStudentByLastname", method = RequestMethod.GET)
	@ResponseBody
	public  String getStudentByLastname(@RequestParam("request") String action){
		ObjectMapper mapper = new ObjectMapper();
		List<Student> studentList = studentService.getStudentByLastName(action);
		String jsonInString="";
		try {
			jsonInString = mapper.writeValueAsString(studentList);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonInString;
	}
	@RequestMapping(value = "/getStudentByCollegeId", method = RequestMethod.GET)
	@ResponseBody
	public  String getStudentByCollegeId(@RequestParam("request") String action){
		ObjectMapper mapper = new ObjectMapper();
		try{
		int collegeId = Integer.parseInt(action);
		
		List<Student> studentList = studentService.getStudentByCollegeId(collegeId);
		String jsonInString="";
		try {
			jsonInString = mapper.writeValueAsString(studentList);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonInString;
		}
		catch(NumberFormatException e){
			return null;
		}
	}
	@RequestMapping(value = "/getStudentByYearLevel", method = RequestMethod.GET)
	@ResponseBody
	public  String getStudentByYearLevel(@RequestParam("request") String action){
		ObjectMapper mapper = new ObjectMapper();
		try{
		int yearLevel = Integer.parseInt(action);
		List<Student> studentList = studentService.getStudentByYearLevel(yearLevel);
		String jsonInString="";
		try {
			jsonInString = mapper.writeValueAsString(studentList);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonInString;
		}
		catch(NumberFormatException e){
			return null;
		}
	} 
	
	
	private List<Object> populateCollege(List<Student> studentList){
		
		List<Object> studentListWithCollege = new ArrayList<Object>();
		
		return null;
	}

	
}
