package com.pakotzy.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {
	//    Define controller methods
	@RequestMapping("showForm")
	public String showForm() {
		return "helloworld-form";
	}

//    Simple request handling without request and response parameters
//    @RequestMapping("processForm")
//    public String processForm() {
//        return "helloworld";
//    }

//    Request handling with request handling by HttpServletRequest, and response via Model
//    @RequestMapping("processForm")
//    public String processForm(HttpServletRequest request, Model response) {
//        response.addAttribute("message", "Yo! " + request.getParameter("studentName").toUpperCase());
//        return "helloworld";
//    }

	//    Request handling with @RequestParam for request, and Model for response
	@RequestMapping("processForm")
	public String processForm(
			@RequestParam("studentName") String name,
			Model response) {
		response.addAttribute("message", "Hello my friend! " + name.toUpperCase());
		return "helloworld";
	}
}
