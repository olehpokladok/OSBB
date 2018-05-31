package com.oleh.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oleh.entity.Indicator;
import com.oleh.entity.User;
import com.oleh.service.IndicatorService;
import com.oleh.service.ServicesService;
import com.oleh.service.UserService;

@Controller
@RequestMapping("/indicator")
public class IndicatorController {
	
	@Autowired
	private IndicatorService indicatorService;

	@Autowired
	private ServicesService servicesService;

	/*
	 * @Autowired private PriceService priceService;
	 */

	@Autowired
	private UserService userService;

	@GetMapping("/add-indicator")
	public String showAddIndicatorForm(Model model) {
		model.addAttribute("indicatorModel", new Indicator());
		model.addAttribute("servicesModel", servicesService.findAllService());

		return "indicator/add-indicator";
	}

	@PostMapping("/add-indicator")
	public String saveIndicator(Model model, @ModelAttribute("indicatorModel") Indicator indicator,
			Principal principal) {
		User user = userService.findUserByLogin(principal.getName());
		indicator.setUser_id(user);
		int now = indicator.getCounter();
		int a = indicatorService.findAllIndicatorByUserId(user).get(indicatorService.findAllIndicatorByUserId(user).size()-1).getCounter();
		if (now >= a) {
			indicatorService.saveIndicator(indicator);
			return "redirect:/payment/add-payment/" + indicator.getServices().getId() + "/" + indicator.getCounter();
		} else {
			return "redirect:/indicator/error/" + indicator.getServices().getId();
		}
	}

	@GetMapping("/list-indicator")
	public String showAllIndicators(Model model) {
		model.addAttribute("indicatorList", indicatorService.findAllIndicator());
		return "indicator/list-indicator";
	}

	@GetMapping("/list-indicator-user")
	public String showAllIndicatorByUser(Model model, Principal principal) {
		User user = userService.findUserByLogin(principal.getName());
		model.addAttribute("indicatorList", indicatorService.findAllIndicatorByUserId(user));
		return "indicator/list-indicator-user";
	}
	
	@GetMapping("/error/{serviceId}")
	public String showError(Model model, @PathVariable("serviceId") int serviceId, Principal principal) {
		model.addAttribute("cuurentUser", userService.findUserByLogin(principal.getName()));
		model.addAttribute("maxCounter", indicatorService.findMaxCounter(servicesService.findServiceById(serviceId)));
		return"indicator/error";
	}
}
