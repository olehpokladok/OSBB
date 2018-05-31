package com.oleh.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oleh.service.IndicatorService;
import com.oleh.service.ServicesService;

@Component
public class CheckIndicatorAreHugestValidator implements ConstraintValidator<CheckIndicatorAreHugest, Integer> {

	@Autowired
	private IndicatorService indicatorService;

	@Autowired
	private ServicesService servicesService;

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	
//	@Override
//	public boolean isValid(String service, ConstraintValidatorContext context) {
//		if (indicatorService.findAllIndicatorByService(servicesService.findServiceByName(service))
//				.get(indicatorService.findAllIndicatorByService(servicesService.findServiceByName(service)).size() - 2)
//				.getCounter()
//				.compareTo(indicatorService
//						.findAllIndicatorByService(servicesService.findServiceByName(service)).get(indicatorService
//								.findAllIndicatorByService(servicesService.findServiceByName(service)).size() - 1)
//						.getCounter()) >= 0) {
//			return false;
//		} else {
//			return true;
//		}
//	}

//	@Override
//	public boolean isValid(Integer value, ConstraintValidatorContext context) {
//	if(indicatorService.findAllIndicatorByService(value).size()-1)
//		return false;
//	}
	
	

}