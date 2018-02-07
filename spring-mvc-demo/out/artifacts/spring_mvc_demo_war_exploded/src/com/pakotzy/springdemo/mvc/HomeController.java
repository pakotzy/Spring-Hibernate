package com.pakotzy.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Define Spring Controller class
@Controller
public class HomeController {
	//    Define Controller method with Request Mapping
	@RequestMapping("/")
	public String getMainPage() {
		return "main-menu";
	}
}
