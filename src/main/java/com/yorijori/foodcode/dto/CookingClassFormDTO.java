package com.yorijori.foodcode.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookingClassFormDTO {
	private int cookFormNo;
	private int cookNo;
	private String userId;
	private String paymentMethod;
	private Date date;
	private Date upDate;
	private int state;
}
