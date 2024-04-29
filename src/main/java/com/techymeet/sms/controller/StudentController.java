package com.techymeet.sms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techymeet.sms.bo.StudentBo;
import com.techymeet.sms.model.EmailModel;
import com.techymeet.sms.service.StudentService;
import com.techymeet.sms.utils.SendEmailService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	SendEmailService emailService;

	@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
	public String list(Model model,HttpServletRequest request) {

		if(null!=request.getAttribute("successMessage")) {
			System.out.println(request.getAttribute("successMessage"));
			model.addAttribute("successMessage", request.getAttribute("successMessage"));
		}
		
		if(null!=request.getAttribute("errorMessage")) {
			System.out.println(request.getAttribute("errorMessage"));
			model.addAttribute("errorMessage", request.getAttribute("errorMessage"));
		}
		
		List<StudentBo> studentList = studentService.findAll();
		if (null != studentList && 0 < studentList.size()) {
			model.addAttribute("studentList", studentList);
		}

		return "student_list";

	}

	@RequestMapping(value = "createStudent", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("studentBo", new StudentBo());
		return "create_student";
	}

	@RequestMapping(value = "manageStudent", method = RequestMethod.POST)
	public String createAndEditStudent(@ModelAttribute("studentBo") StudentBo studentBo, Model model,HttpServletRequest request) {
		int studentId = studentService.saveOrUpdate(studentBo);
		if (0 < studentId) {
			model.addAttribute("successMessage", "Student Creation Successfully!");
			
			studentRegistrationMail(studentBo);
			
			
			System.out.println(model.getAttribute("successMessage"));
			if(0 < studentId && 0<studentBo.getStudentId()) {
				model.addAttribute("successMessage", "Student updation Successfully!");
			}else {
				model.addAttribute("errorMessage", "Student updation Failed!");
			}
		} else {
			model.addAttribute("errorMessage", "Student Creation Failed!");
			System.out.println(model.getAttribute("errorMessage"));
		}
		return "redirect:/listStudent";

	}
	

	private void studentRegistrationMail(StudentBo studentBo) {
		EmailModel model=new EmailModel();
		final String toaddress=studentBo.getEmailId();
		final String subject = "SMS:Student Registration Details!";
		String bodycontent = "Student Registration";
		model.setUserName(studentBo.getEmailId());
		model.setPassword(studentBo.getPassWord());

		String success=emailService.sendStudentRegisterEmail(toaddress,bodycontent, subject, model);
		System.out.println(success);
	}

	@RequestMapping(value = "viewStudent", method = RequestMethod.GET)
	public String view(@RequestParam("studentId") int studentId, Model model) {
		StudentBo student = null;
		try {

			student = studentService.findById(studentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != student) {
			model.addAttribute("student", student);
			return "view_student";
		}
		return null;
	}

	@RequestMapping(value = "editStudent", method = RequestMethod.GET)
	public String edit(@RequestParam("studentId") int studentId, Model model) {
		StudentBo student = null;
		try {

			student = studentService.findById(studentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != student) {
			model.addAttribute("studentBo", student);
			return "create_student";
		}
		return null;
	}

	@RequestMapping(value = "deleteStudent", method = RequestMethod.GET)
	public String delete(@RequestParam("studentId") int studentId,Model model) {
		boolean status = false;
		try {
			status = studentService.delete(studentId);
		} catch (Exception e) {
			e.printStackTrace();

		}
		if (status) {
			model.addAttribute("successMessage", "Student deletion Successfully!");
			return "redirect:/listStudent";
		} else {
			model.addAttribute("errorMessage", "Student deletion Failed!");
			return "redirect:/listStudent";
		}

	}

	// Request url -- http://localhost:8090/SmsBootHibernate/student/name/aravinth

	@GetMapping("/student/name/{name}")
	public ResponseEntity<StudentBo> searchByName(@PathVariable String name) {
		StudentBo student = null;
		try {

			student = studentService.findByStudentName(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != student) {
			return new ResponseEntity<StudentBo>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentBo>(student, HttpStatus.NOT_FOUND);
		}
	}

	// Request url --
	// http://localhost:8090/SmsBootHibernate/student/email?email=aravinth.techymeet@gmail.com

	@GetMapping("/student/email")
	public ResponseEntity<StudentBo> searchByEmail(@RequestParam("email") String email) {
		StudentBo student = null;
		try {

			student = studentService.findByStudentEmail(email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != student) {
			return new ResponseEntity<StudentBo>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentBo>(student, HttpStatus.NOT_FOUND);
		}
	}

	// Request url
	// --http://localhost:8090/SmsBootHibernate/student/mobile?mobile=8825958422
	@GetMapping("/student/mobile")
	public ResponseEntity<StudentBo> searchByMobileNumber(@RequestParam("mobile") long mobile) {
		StudentBo student = null;
		try {

			student = studentService.findByMobileNumber(mobile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != student) {
			return new ResponseEntity<StudentBo>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentBo>(student, HttpStatus.NOT_FOUND);
		}
	}
}
