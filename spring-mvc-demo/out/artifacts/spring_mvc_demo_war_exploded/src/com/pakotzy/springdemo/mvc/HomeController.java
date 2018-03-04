package com.pakotzy.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Define Spring Controller class
@Controller
public class HomeController {
	public HomeController() {
		System.out.println("Hi");
	}
	//    Define Controller method with Request Mapping
	@RequestMapping("/")
	public String getMainPage() {
		String name = "randomstring";
		return "main-menu";
	}
}
