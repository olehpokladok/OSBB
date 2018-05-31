package com.oleh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oleh.entity.Services;
import com.oleh.service.ServicesService;

@Controller
@RequestMapping("/services")
public class ServicesController {

	@Autowired
	private ServicesService servicesService;

	@GetMapping("/add-service")
	public String showAddServicesForm(Model model) {
		model.addAttribute("servicesModel", new Services());
		return "services/add-service";
	}

	@PostMapping("/add-service")
	public String saveService(@ModelAttribute("serviceModel") Services service) {
		servicesService.saveService(service);
		return "redirect:/";
	}
}
