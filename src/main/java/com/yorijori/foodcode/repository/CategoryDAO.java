package com.yorijori.foodcode.repository;

import java.util.List;

import com.yorijori.foodcode.jpa.entity.Category;
import com.yorijori.foodcode.jpa.entity.UserFrige;

public interface CategoryDAO {
	List<Category> selectAll();
	
}
