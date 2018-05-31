package com.oleh.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oleh.entity.Indicator;
import com.oleh.entity.Payment;
import com.oleh.entity.User;
import com.oleh.service.IndicatorService;
import com.oleh.service.PaymentService;
import com.oleh.service.PriceService;
import com.oleh.service.ServicesService;
import com.oleh.service.UserService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private IndicatorService indicatorService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ServicesService servicesService;
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/add-payment/{serviceId}/{newcounter}")
	public String showAddIndicatorForm(@PathVariable("serviceId") int serviceId,
										@PathVariable("newcounter") int newcounter,
										Model model, Principal principal, @ModelAttribute("indicatorModel") Indicator indicator) {
		
		User user = userService.findUserByLogin(principal.getName());
		System.out.println(indicatorService.findMaxIndicatorByServiceAndUser(serviceId, user.getId()));
		
		model.addAttribute("cuurentUser", userService.findUserByLogin(principal.getName()));
		model.addAttribute("paymentModel", new Payment());
		model.addAttribute("data", new Date());
		model.addAttribute("allIndicator", indicatorService.findAllIndicatorByService(servicesService.findServiceById(serviceId))
										.get(indicatorService.findAllIndicatorByService(servicesService.findServiceById(serviceId))
												.size() - 2));
		model.addAttribute("newCounter", newcounter);
//		model.addAttribute("maxCounter", indicatorService.findMaxCounter(servicesService.findServiceById(serviceId)));
		model.addAttribute("maxPrice", priceService.findMaxPrice(servicesService.findServiceById(serviceId)));
		model.addAttribute("currentService", servicesService.findServiceById(serviceId).getName());
		model.addAttribute("servicesModel", servicesService.findAllService());
		return "payment/add-payment";
	}
	
	@PostMapping("/add-payment")
	public String saveIndicator(Model model, @ModelAttribute("paymentModel") Payment payment, Principal principal)	{
//		Services service = 
		User user = userService.findUserByLogin(principal.getName());
		payment.setUser_id(user);
		paymentService.savePayment(payment);
		return "redirect:/";
	}

	@GetMapping("/list-payments")
	public String showAllPayments(Model model, Principal principal) {
//		User user = userService.findUserByLogin(principal.getName());
//		model.addAttribute("currentUser", paymentService.findAllPaymentByUserId(user));
		model.addAttribute("paymentsList", paymentService.findAllPayment());
		return "payment/list-payments";
	}
	
	@GetMapping("/list-payment-user")
	public String showAllPaymentsByUserId(Model model, Principal principal) {
		User user = userService.findUserByLogin(principal.getName());
		model.addAttribute("listPayment", paymentService.findAllPaymentByUserId(user));
		return "payment/list-payment-user";
	}
	
	@GetMapping("/flat-count")
	public String showFormPayForFlat(Model model, Principal principal) {
		User user = userService.findUserByLogin(principal.getName());
		model.addAttribute("maxPrice", priceService.findMaxPrice(servicesService.findServiceById(4)));
		model.addAttribute("currentUser", user.getArea());
		return "payment/flat-count";
	}
	
	@PostMapping("/flat-count")
	public String payForFlat(Model model, Principal principal, @ModelAttribute("paymentModel") Payment payment) {
		User user = userService.findUserByLogin(principal.getName());
		payment.setUser_id(user);
		model.addAttribute("maxPrice", priceService.findMaxPrice(servicesService.findServiceById(4)));
		model.addAttribute("data", new Date());
		model.addAttribute("currentUser", user.getArea());
		paymentService.savePayment(payment);
		return "redirect:/";
	}
}
