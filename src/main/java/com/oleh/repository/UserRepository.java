package com.oleh.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oleh.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.login = :login")
	User findUserByLogin(@Param("login") String login);
	
	@Query("SELECT u FROM User u WHERE u.flat = :flat")
	User findUserByFlat(@Param("flat") String flat);
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findUserByEmail(@Param("email") String email);
	
	@Query("SELECT u.area FROM User u WHERE u.id = :id")
	BigDecimal findAreaByUserId(@Param("id") User id);
}
