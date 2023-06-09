package com.yorijori.foodcode.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yorijori.foodcode.jpa.entity.CookingClass;
import com.yorijori.foodcode.jpa.entity.UserInfo;

@Repository
public interface CookingClassRepository extends JpaRepository<CookingClass, Integer>{
	public List<CookingClass> findByState(int state);
	public Page<CookingClass> findByState(int state, Pageable pageable);
	public List<CookingClass> findTop5ByStateOrderByCountDesc(int state);
	public List<CookingClass> findByUserIdAndState(UserInfo userId, int state);

	public Page<CookingClass> findByUserId(UserInfo user, PageRequest pageRequest);

	public long countByUserId(UserInfo user);
	Page<CookingClass> findByTitleContaining(String keyword,Pageable pageable);
	Long countByTitleContaining(String title);
	Page<CookingClass> findByStateAndCategory(int state,String category, PageRequest pageRequest);
}
