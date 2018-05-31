package com.oleh.mapper;

import org.springframework.security.core.authority.AuthorityUtils;

import com.oleh.domain.AddUserRequest;
import com.oleh.entity.Indicator;
import com.oleh.entity.User;
import com.oleh.entity.enums.UserRole;

public class UserMapper {

	public static User addUserRequestToUser(AddUserRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setLogin(request.getLogin());
		user.setPassword(request.getPassword());
		user.setRole(UserRole.ROLE_USER);
		return user;
	}
	
	public static org.springframework.security.core.userdetails.User 
			toSecurityUser(User user) {
		return new org.springframework.security.core.userdetails.User(
					user.getLogin(),
					user.getPassword(),
					AuthorityUtils.createAuthorityList(String.valueOf(user.getRole()))
				);
	}
}
