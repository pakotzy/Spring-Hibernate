package com.pakotzy.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	@GetMapping("/")
	public String getHome() {
		return "home";
	}

	@GetMapping("/boss")
	public String getBoss() { return "boss"; }
}
