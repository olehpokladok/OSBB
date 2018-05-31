 package com.oleh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oleh.domain.PriceFilter;
import com.oleh.entity.Price;
import com.oleh.entity.Services;
import com.oleh.service.PriceService;
import com.oleh.service.ServicesService;

@Controller
@RequestMapping("/price")
public class PriceController {

	@Autowired
	private ServicesService servicesService;
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/add-price")
	public String showAddPriceForm(Model model) {
		model.addAttribute("priceModel", new Price());
		model.addAttribute("servicesModel", servicesService.findAllService());
		return "price/add-price";
	}
	
	@PostMapping("/add-price")
	public String savePrice(Model model, @ModelAttribute("priceModel") Price price) {
		priceService.savePrice(price);
		return "redirect:/";
	}

	@GetMapping("/list-prices")
	public String showAllPrices(Model model) {
		model.addAttribute("priceList", priceService.findAllPrice());
		return "price/list-prices";
	}
	
	@GetMapping("/list-prices/search")
	public String showPriceByFilter(Model model, @RequestParam(value = "search", required = false) Services search) {
		
		PriceFilter filter = null;
		if(search != null) {
			filter = new PriceFilter(search);
		}
		model.addAttribute("pricesList", priceService.findPriceByFilter(filter));
		
		return "price/list-prices";
	}
	
	@GetMapping("/list-user-prices")
	public String showAllPricesUsers(Model model) {
//		List<Services> service = servicesService.findAllService();
		model.addAttribute("priceList1", priceService.findMaxPrice(servicesService.findServiceById(1)));
		model.addAttribute("priceList2", priceService.findMaxPrice(servicesService.findServiceById(2)));
		model.addAttribute("priceList3", priceService.findMaxPrice(servicesService.findServiceById(3)));
		model.addAttribute("priceList5", priceService.findMaxPrice(servicesService.findServiceById(4)));
		return"price/list-user-prices";
	}
}
