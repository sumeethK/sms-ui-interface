package com.sumeeth.controller;

import com.sumeeth.constants.Action;
import com.sumeeth.model.College;
import com.sumeeth.model.Student;
import com.sumeeth.service.ICollegeService;
import com.sumeeth.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class StudentController {
    College college = new College();
    private IStudentService studentService;
    private ICollegeService collegeService;

    @RequestMapping("/student.index")
	public String setupForm(Map<String, Object> map){
		Student student = new Student();
		
		map.put("collegeObject", college);
		map.put("collegeList", collegeService.getAllCollege());
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
	@RequestMapping("/student.detail")
	public String getStudentDetail(Map<String, Object> map){
		return "student-details";
	}
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Student studentResult = new Student();
		College collegeName = new College();
        Action studentAction = Action.valueOf(action.toUpperCase());

        switch (studentAction) {    //only in Java7 you can put String in switch
            case ADD:
                studentService.add(student);
                studentResult = student;
                break;
            case EDIT:
                studentService.edit(student);
                studentResult = student;
                break;
            case DELETE:
                studentService.delete(student.getStudentId());
                studentResult = new Student();
                break;
            case SEARCH:
                Student searchedStudent = studentService.getStudent(student.getStudentId());
                studentResult = searchedStudent != null ? searchedStudent : new Student();
                collegeName =studentResult.getCollegeId()!=0 ? collegeService.getCollegeById(studentResult.getCollegeId()):new College(0,"No College Mentioned","");
			break;
		}
		map.put("collegeName", collegeName);
		map.put("collegeObject", college);
		map.put("collegeList", collegeService.getAllCollege());
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
}
