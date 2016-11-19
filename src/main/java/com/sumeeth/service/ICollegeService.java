package com.sumeeth.service;

import java.util.List;

import com.sumeeth.model.College;
import com.sumeeth.model.Student;

public interface ICollegeService {
	void add(College college);

	void edit(College college);

	void delete(int id);

	List getAllCollege();

	College getCollegeById(int id);

}
