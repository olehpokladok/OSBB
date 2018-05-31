package com.oleh.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oleh.entity.Indicator;
import com.oleh.entity.User;
import com.oleh.entity.enums.UserRole;
import com.oleh.service.IndicatorService;
import com.oleh.service.ServicesService;
import com.oleh.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private ServicesService servicesService;

	@Autowired
	private IndicatorService indicatorService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showHome(Model model) {
		model.addAttribute("title", "Home page");
		return "home";
	}

	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("title", "Login Page");
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("userModel", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("userModel") User user1, BindingResult br, Indicator indicator, Principal principal) {
		if (br.hasErrors()) {
			return "register";
		}
		
		user1.setRole(UserRole.ROLE_USER);
		userService.saveUser(user1);

		return "redirect:/login";
	}
	
	@GetMapping("/verify")
	public String varifyEmail(@RequestParam("token") String token, @RequestParam("userid") String userid) {
		User user = userService.findUserById(Integer.valueOf(userid));
		if(user.getTaken().equals(token)) {
			user.setTaken(null);
			userService.updateUser(user);
		}else {
			return "redirect:/?validate=false";
		}
		return "home";
	}
}
