package org.bmit.flightreservation.controller;

import org.bmit.flightreservation.model.User;
import org.bmit.flightreservation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showreg")
	public String showRegistrationPage() {
		return "login/register";
	}
	
	@RequestMapping("/showlogin")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
		User user = userRepository.findByEmail(email);
		if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
			return "findflights";
		}else {
			modelMap.addAttribute("msg", "Invalid username [or] password please try again");
		}
		return "login/login";
	}
	
	
	
	
	
	
	
	
	
	
}
