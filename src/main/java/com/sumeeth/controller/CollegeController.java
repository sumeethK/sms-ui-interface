package com.sumeeth.controller;

import com.sumeeth.constants.Action;
import com.sumeeth.model.College;
import com.sumeeth.service.ICollegeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class CollegeController {
	private ICollegeService collegeService;
	
	@RequestMapping("/college.index")
	public String setupForm(Map<String, Object> map){
		College college = new College();
		map.put("college", college);
		map.put("collegeList", collegeService.getAllCollege());
		return "college";
	}
	@RequestMapping(value="/college.do", method=RequestMethod.POST)
	public String doActions(@Valid @ModelAttribute("college") College college, BindingResult result, @RequestParam String action, Map<String, Object> map){
		College collegeResult = new College();
		Action collegeAction = Action.valueOf(action.toUpperCase());
		switch (collegeAction) {    //only in Java7 you can put String in switch
			case ADD:
			if(result.hasErrors()){
				System.out.println("validation error");
				return "college";
			}
			collegeService.add(college);
			collegeResult = college;
			break;
			case EDIT:
			collegeService.edit(college);
			collegeResult = college;
			break;
			case DELETE:
			collegeService.delete(college.getId());
			collegeResult = new College();
			break;
			case SEARCH:
			College searchedCollege = collegeService.getCollegeById(college.getId());
			collegeResult = searchedCollege!=null ? searchedCollege : new College();
			break;
		}
		map.put("college", collegeResult);
		map.put("collegeList", collegeService.getAllCollege());
		return "college";
	}
}
