package com.oleh.service;

import java.math.BigDecimal;
import java.util.List;

import com.oleh.entity.User;

public interface UserService {

	void saveUser(User user);

	User findUserById(int id);

	List<User> findAllUsers();

	User findUserByLogin(String login);

	User findUserByEmail(String email);

	User findUserByFlat(String flat);
	
	BigDecimal findAreaByUserId(User id);

	void updateUser(User user);
}
