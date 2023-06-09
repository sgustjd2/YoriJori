package com.yorijori.foodcode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookingClassContentDTO {
	private int contentNo;
	private int cookNo;
	private String conCategory;
	private String content;
}
