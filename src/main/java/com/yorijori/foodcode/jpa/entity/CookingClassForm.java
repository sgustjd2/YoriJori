package com.yorijori.foodcode.jpa.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cooking_class_form")
public class CookingClassForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cookFormNo;
	private String name;
	private String email;
	private String phone;
	@CreationTimestamp
	private Date date;
	@UpdateTimestamp
	private Date upDate;
	private int state;
	
	
	@Exclude
	@OneToOne(mappedBy = "cookFormNo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Payment payment = new Payment();
	
	
	
	@Exclude
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private UserInfo userId;
	
	@Exclude
	@ManyToOne
	@JoinColumn(name = "cookNo", nullable=false)
	private CookingClass cookNo;
	
	
}
