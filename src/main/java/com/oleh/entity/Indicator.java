package com.oleh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.oleh.validator.CheckIfEmailExists;
import com.oleh.validator.CheckIndicatorAreHugest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "indicator")
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class Indicator extends BaseEntity{

	@CreationTimestamp
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();
	
	@Column(name = "counter")
	private Integer counter;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "services_name")
	private Services services;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user_id;
	
}
