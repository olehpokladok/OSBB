package com.oleh.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oleh.entity.User;
import com.oleh.repository.UserRepository;
import com.oleh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByLogin(String login) {
		return userRepository.findUserByLogin(login);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public User findUserByFlat(String flat) {
		return userRepository.findUserByFlat(flat);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public BigDecimal findAreaByUserId(User id) {
		return userRepository.findAreaByUserId(id);
	}

	
}
