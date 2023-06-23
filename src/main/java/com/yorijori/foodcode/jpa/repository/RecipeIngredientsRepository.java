package com.yorijori.foodcode.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yorijori.foodcode.jpa.entity.RecipeIngredients;

public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, Integer> {

}
