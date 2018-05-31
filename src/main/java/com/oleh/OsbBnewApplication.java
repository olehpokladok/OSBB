package com.oleh;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oleh.entity.Services;
import com.oleh.entity.User;
import com.oleh.entity.enums.UserRole;
import com.oleh.repository.ServiceRepository;
import com.oleh.repository.UserRepository;

@SpringBootApplication
public class OsbBnewApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OsbBnewApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OsbBnewApplication.class, args);
		addAdmin(context);
		addWater(context);
		addGaz(context);
		addLight(context);
		addFlatCount(context);
	}

	static void addAdmin(ConfigurableApplicationContext context) {
		String login = "admin";
		String password = "123";
		String flat = "0";
		String email = "admin@gmail.com";
		BigDecimal area = new BigDecimal("1.5");

		UserRepository userRepository = context.getBean(UserRepository.class);
		User user = userRepository.findUserByLogin(login);

		if (user == null) {
			PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
			user = new User();
			user.setEmail(email);
			user.setArea(area);
			user.setFlat(flat);
			user.setLogin(login);
			user.setPassword(passwordEncoder.encode(password));
			user.setRole(UserRole.ROLE_ADMIN);

			userRepository.save(user);
		}

	}
	static void addWater(ConfigurableApplicationContext context) {
		String name = "water";
		ServiceRepository serviceRepository = context.getBean(ServiceRepository.class);
		Services service = serviceRepository.findServiceByName(name);
		if (service == null) {
			service = new Services();
			service.setName(name);
			serviceRepository.save(service);
		}
	}
	static void addGaz(ConfigurableApplicationContext context) {
		String name = "gaz";
		ServiceRepository serviceRepository = context.getBean(ServiceRepository.class);
		Services service = serviceRepository.findServiceByName(name);
		if (service == null) {
			service = new Services();
			service.setName(name);
			serviceRepository.save(service);
		}
	}
	static void addLight(ConfigurableApplicationContext context) {
		String name = "light";
		ServiceRepository serviceRepository = context.getBean(ServiceRepository.class);
		Services service = serviceRepository.findServiceByName(name);
		if (service == null) {
			service = new Services();
			service.setName(name);
			serviceRepository.save(service);
		}
	}
	static void addFlatCount(ConfigurableApplicationContext context) {
		String name = "flat";
		ServiceRepository serviceRepository = context.getBean(ServiceRepository.class);
		Services service = serviceRepository.findServiceByName(name);
		if (service == null) {
			service = new Services();
			service.setName(name);
			serviceRepository.save(service);
		}
	}

}
