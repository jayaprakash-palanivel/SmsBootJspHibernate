package com.techymeet.sms.dao;

import java.util.List;

import com.techymeet.sms.vo.StudentVo;

public interface StudentDao {

	
	StudentVo findById(int studentId);
	
	List<StudentVo> findAll();
	
	boolean delete(int studentId);
	
	StudentVo findByStudentEmail(String email);

	StudentVo findByMobileNumber(long mobile);

	StudentVo findByStudentName(String name);

	int saveOrUpdate(StudentVo studentVo);
}
