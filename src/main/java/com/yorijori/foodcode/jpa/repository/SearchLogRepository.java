package com.yorijori.foodcode.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yorijori.foodcode.jpa.entity.SearchLog;

public interface SearchLogRepository extends JpaRepository<SearchLog, Integer>{
	List<SearchLog> findTop10ByOrderByCountDesc();
	List<SearchLog> findTop100ByOrderByCountDesc();
	SearchLog findByKeyword(String keyword); 
	}
