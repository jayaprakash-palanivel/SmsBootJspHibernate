package com.techymeet.sms.service;

import java.util.List;

import com.techymeet.sms.bo.StudentBo;

public interface StudentService {
	
	StudentBo findById(int studentId);
	
	List<StudentBo> findAll();
	
	boolean delete(int studentId);

	StudentBo findByStudentEmail(String email);

	StudentBo findByMobileNumber(long mobile);

	StudentBo findByStudentName(String name);

	int saveOrUpdate(StudentBo studentBo);
	
	
	
	
}
