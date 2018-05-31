package com.oleh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "services")
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class Services extends BaseEntity{

	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "price", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Price> price = new ArrayList<>();
	
	@OneToMany(mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Indicator> indicator = new ArrayList<>();
	
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Payment> service = new ArrayList<>();

	
}
