package com.yorijori.foodcode.service;

import java.util.List;

import com.yorijori.foodcode.jpa.entity.Category;


public interface CategoryService {
    List<Category> findAll();
    List<Category> findByLevel(Integer upperLevel);
    List<Category> findByLevelAndUpperLevel(int level, String upperlevel);
    List<Category> findByUpperLevel(String upperlevel);
}
