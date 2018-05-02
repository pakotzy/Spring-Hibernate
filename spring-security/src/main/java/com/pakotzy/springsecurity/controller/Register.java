package com.pakotzy.springsecurity.controller;

import com.pakotzy.springsecurity.persistance.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class Register {
	@Autowired
	private UserDetailsManager userDetailsManager;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model theModel) {
		theModel.addAttribute("user", new UserDAO());

		return "registration";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("user") UserDAO userModel, BindingResult bindingResult,
	                                      Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", new UserDAO());
			model.addAttribute("registrationError", "User name/password can not be empty.");

			return "registration";
		}

		if (doesUserExist(userModel.getUserName())) {
			model.addAttribute("user", new UserDAO());
			model.addAttribute("registrationError", "User with this name is already exists.");

			return "registration";
		}

		String encodedPassword = "{bcrypt}" + passwordEncoder.encode(userModel.getPassword());

		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_P");
		User user = new User(userModel.getUserName(), encodedPassword, authorities);

		userDetailsManager.createUser(user);

		return "registration-confirmation";
	}

	private boolean doesUserExist(String userName) {
		return userDetailsManager.userExists(userName);
	}
}
