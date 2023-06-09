package com.yorijori.foodcode.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="recipe_qa")
public class RecipeQa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qaNo;
	//private int recipeNo;

	private String title;
	private String contents;
	private int depthLevel;
	@CreationTimestamp
	private Date date;
	@UpdateTimestamp
	private Date upDate;
	private int state; //default 0
	
	@Exclude
	@ManyToOne
	@JoinColumn(name = "recipeNo", nullable=false)
	@JsonBackReference
	private Recipe recipeNo;
	

	@Exclude
	@ManyToOne
	@JoinColumn(name = "userId", nullable=false)
	@JsonBackReference
	private UserInfo userId;
}
