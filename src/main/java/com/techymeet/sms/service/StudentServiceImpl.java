package com.techymeet.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techymeet.sms.bo.StudentBo;
import com.techymeet.sms.dao.StudentDao;
import com.techymeet.sms.vo.StudentVo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	
	@Override
	public int saveOrUpdate(StudentBo studentBo) {
		StudentVo StudentVo = new StudentVo();
		if(0<studentBo.getStudentId()) {
			StudentVo.setStudentId(studentBo.getStudentId());
		}
		StudentVo.setStudentName(studentBo.getStudentName());
		StudentVo.setEmailId(studentBo.getEmailId());
		StudentVo.setMobileNumber(studentBo.getMobileNumber());
		StudentVo.setPassword(studentBo.getPassWord());
		StudentVo.setDateOfBirth(studentBo.getDateOfBirth());
		StudentVo.setAddress(studentBo.getAddress());
		StudentVo.setCity(studentBo.getCity());
		StudentVo.setCountry(studentBo.getCountry());
		StudentVo.setIsDelete(false);
		int studentId = studentDao.saveOrUpdate(StudentVo);
		if (0 < studentId) {
			return studentId;
		}
		
		return 0;
	}


	@Override
	public StudentBo findById(int studentId) {
		StudentBo StudentBo = new StudentBo();

		StudentVo StudentVo = studentDao.findById(studentId);
		if (null != StudentVo) {
			StudentBo.setStudentId(StudentVo.getStudentId());
			StudentBo.setStudentName(StudentVo.getStudentName());
			StudentBo.setEmailId(StudentVo.getEmailId());
			StudentBo.setMobileNumber(StudentVo.getMobileNumber());
			StudentBo.setPassWord(StudentVo.getPassword());
			StudentBo.setDateOfBirth(StudentVo.getDateOfBirth());
			StudentBo.setAddress(StudentVo.getAddress());
			StudentBo.setCity(StudentVo.getCity());
			StudentBo.setCountry(StudentVo.getCountry());
			if (null != StudentBo) {
				return StudentBo;
			}

		}
		return null;
	}

	@Override
	public List<StudentBo> findAll() {
		List<StudentBo> studentBoList = new ArrayList<StudentBo>();

		List<StudentVo> studentVoList = studentDao.findAll();
		if (null != studentVoList && 0 < studentVoList.size()) {
		int count=1;
			for (StudentVo StudentVo : studentVoList) {
				StudentBo StudentBo = new StudentBo();
				StudentBo.setSerialNo(count);
				StudentBo.setStudentId(StudentVo.getStudentId());
				StudentBo.setStudentName(StudentVo.getStudentName());
				StudentBo.setEmailId(StudentVo.getEmailId());
				StudentBo.setMobileNumber(StudentVo.getMobileNumber());
				StudentBo.setPassWord(StudentVo.getPassword());
				StudentBo.setDateOfBirth(StudentVo.getDateOfBirth());
				StudentBo.setAddress(StudentVo.getAddress());
				StudentBo.setCity(StudentVo.getCity());
				StudentBo.setCountry(StudentVo.getCountry());
				//StudentBo.setIsDelete(StudentVo.getIsDelete());
				studentBoList.add(StudentBo);
				
				count++;
			}
		}
		if (null != studentBoList && 0 < studentBoList.size()) {
			return studentBoList;
		}

		return null;
	}

	@Override
	public boolean delete(int studentId) {
		boolean status = studentDao.delete(studentId);
		if(status) {
			return status;
		}
		return false;
	}

	@Override
	public StudentBo findByStudentEmail(String email) {
		StudentBo StudentBo = new StudentBo();

		StudentVo StudentVo = studentDao.findByStudentEmail(email);
		if (null != StudentVo) {
			StudentBo.setStudentId(StudentVo.getStudentId());
			StudentBo.setStudentName(StudentVo.getStudentName());
			StudentBo.setEmailId(StudentVo.getEmailId());
			StudentBo.setMobileNumber(StudentVo.getMobileNumber());
			StudentBo.setPassWord(StudentVo.getPassword());

			if (null != StudentBo) {
				return StudentBo;
			}

		}

		return null;
	}

	@Override
	public StudentBo findByMobileNumber(long mobile) {
		StudentBo StudentBo = new StudentBo();

		StudentVo StudentVo = studentDao.findByMobileNumber(mobile);
		if (null != StudentVo) {
			StudentBo.setStudentId(StudentVo.getStudentId());
			StudentBo.setStudentName(StudentVo.getStudentName());
			StudentBo.setEmailId(StudentVo.getEmailId());
			StudentBo.setMobileNumber(StudentVo.getMobileNumber());
			StudentBo.setPassWord(StudentVo.getPassword());

			if (null != StudentBo) {
				return StudentBo;
			}

		}

		return null;
	}

	@Override
	public StudentBo findByStudentName(String name) {
		StudentBo StudentBo = new StudentBo();

		StudentVo StudentVo = studentDao.findByStudentName(name);
		if (null != StudentVo) {
			StudentBo.setStudentId(StudentVo.getStudentId());
			StudentBo.setStudentName(StudentVo.getStudentName());
			StudentBo.setEmailId(StudentVo.getEmailId());
			StudentBo.setMobileNumber(StudentVo.getMobileNumber());
			StudentBo.setPassWord(StudentVo.getPassword());

			if (null != StudentBo) {
				return StudentBo;
			}

		}

		return null;
	}

	

}
