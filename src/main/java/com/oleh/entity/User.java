package com.oleh.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.oleh.entity.enums.UserRole;
import com.oleh.validator.CheckIfEmailExists;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class User extends BaseEntity {

	@NotNull(message = "Can't be null")
	@NotEmpty(message = "Con't be empty")
	@Column(name = "login", nullable = false, unique = true) 
	private String login;
	
	@CheckIfEmailExists
	@NotNull(message = "Can't be null")
	@NotEmpty(message = "Con't be empty")
	@Column(name = "email") //, nullable = false, unique = true) 
	private String email;
	
	@NotNull(message = "Can't be null")
	@NotEmpty(message = "Con't be empty")
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull(message = "Can't be null")
	@NotEmpty(message = "Con't be empty")
	@Column(name = "flat", nullable = false)
	private String flat;
	

	
	@Column(name = "area")// nullable = false)
	private BigDecimal area;
	
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	
	private String taken;
	
	@OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Indicator> indicator = new ArrayList<>();
	
	@OneToMany(mappedBy = "cost", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Payment> payment = new ArrayList<>();
}
