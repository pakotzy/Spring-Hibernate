package com.pakotzy.springhibernate.webcustomertracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestDbConnection {

	@RequestMapping("/")
	public String getConnection(Model model) {
		model.addAttribute("conStatus", "Good");
		return "connection";
	}
}
