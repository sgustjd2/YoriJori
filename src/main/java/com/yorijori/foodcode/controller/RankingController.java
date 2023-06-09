package com.yorijori.foodcode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yorijori.foodcode.jpa.entity.Recipe;
import com.yorijori.foodcode.jpa.entity.SearchLog;
import com.yorijori.foodcode.jpa.entity.UserInfo;
import com.yorijori.foodcode.service.MemberService;
import com.yorijori.foodcode.service.RecipeService;
import com.yorijori.foodcode.service.SearchLogService;

@Controller
@RequestMapping("/ranking")
public class RankingController {
	SearchLogService searchservice;
	MemberService memberService;
	RecipeService recipeService;

	@Autowired
	public RankingController(SearchLogService searchservice,MemberService memberService,
	RecipeService recipeService) {
		super();
		this.searchservice = searchservice;
		this.memberService = memberService;
		this.recipeService = recipeService;
	}

	@RequestMapping("/rlist")
	public String reciperank(Model model) {
		List<Recipe> list = recipeService.getTop15Recipe();
		List<Recipe> top3list = new ArrayList<Recipe>();
		List<Recipe> rcplist = new ArrayList<Recipe>();
		for ( int i = 0 ; i < list.size(); i++) {
			if ( i < 3 ) {
				top3list.add(list.get(i));
			} else {
				rcplist.add(list.get(i));
			}
		}
		model.addAttribute("top3list", top3list);
		model.addAttribute("rcplist", rcplist);
		return "thymeleaf/ranking/rrankinglist";
	}
	
	@RequestMapping("/klist")
	public String keywordrank(Model model) {
		List<SearchLog> top10list = searchservice.findTop10ByCount();
		List<SearchLog> searchlist = searchservice.findTop100ByCount();
		model.addAttribute("searchlist", searchlist);
		model.addAttribute("top10list", top10list);
		return "thymeleaf/ranking/krankinglist";
	}
	
	@RequestMapping("/clist")
	public String chefrank(Model model) {
		List<UserInfo> list = memberService.getTop10User();
		model.addAttribute("list", list);
		return "thymeleaf/ranking/crankinglist";
	}

}