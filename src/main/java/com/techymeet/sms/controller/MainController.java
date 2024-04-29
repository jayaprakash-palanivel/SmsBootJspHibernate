package com.techymeet.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techymeet.sms.bo.LoginBo;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("loginBo", new LoginBo());
		return "login";
	}
}
