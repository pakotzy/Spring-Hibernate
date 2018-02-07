package com.pakotzy.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;

@Controller
@RequestMapping("student")
public class StudentController {
	private LinkedHashMap<String, String> countries;
	private LinkedHashMap<String, String> languages;
	private LinkedHashMap<String, String> systems;

//	Pre fill a fields with data
	public StudentController() {
		countries = new LinkedHashMap<>();
		countries.put("ea", "Earth");
		countries.put("vn", "Venus");
		countries.put("bh", "Black Hole");

		languages = new LinkedHashMap<>();
		languages.put("Java", "Java");
		languages.put("C#", "C#");
		languages.put("Ruby", "Ruby");
		languages.put("Delphi", "Delphi");

		systems = new LinkedHashMap<>();
		systems.put("MS Windows", "MS Windows");
		systems.put("Linux", "Linux");
		systems.put("Mac OS", "Mac OS");
	}

	//	Create method to link Model to a Spring Form
	@RequestMapping("showForm")
	public String showForm(Model model) {
//		Add Data class to the Model, it will later used as container for input fields
		model.addAttribute("student", new Student());
		model.addAttribute("countries", countries);
		model.addAttribute("languages", languages);
		model.addAttribute("systems", systems);
		return "student-form";
	}

	//	Create method to process filled Model from a Spring Form
	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		return "student-confirmation";
	}
}
