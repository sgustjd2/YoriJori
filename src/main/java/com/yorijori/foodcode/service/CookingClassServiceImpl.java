package com.yorijori.foodcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yorijori.foodcode.jpa.entity.CookingClass;
import com.yorijori.foodcode.jpa.entity.CookingClassContent;
import com.yorijori.foodcode.jpa.entity.CookingClassCurriculum;
import com.yorijori.foodcode.jpa.entity.CookingClassForm;
import com.yorijori.foodcode.jpa.entity.CookingClassImage;
import com.yorijori.foodcode.jpa.entity.UserInfo;
import com.yorijori.foodcode.repository.CookingClassDAO;

@Service
@Transactional
public class CookingClassServiceImpl implements CookingClassService {
	CookingClassDAO dao;

	@Autowired
	public CookingClassServiceImpl(CookingClassDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void delete(int cookNo) {
		dao.delete(cookNo);
	}

	@Override
	public void restore(int cookNo) {
		dao.restore(cookNo);
	}

	@Override
	public List<CookingClass> selectAllClass(int state) {
		return dao.selectAllClass(state);
	}

	@Override
	public void insert(CookingClass cookingclass) {
//		cookingclass = dao.insertClass(cookingclass);
		List<CookingClassContent> contentList = cookingclass.getContentList();
		List<CookingClassCurriculum> curriList = cookingclass.getCurriList();
		// 컨텐츠 insert

//		System.out.println("--------------------------------");
//		System.out.println(cookingclass);
//		System.out.println("--------------------------------");

		for (int i = 0; i < contentList.size(); i++) {
			contentList.get(i).setCookNo(cookingclass);
		}

		// 커리큘럼 insert
		for (int i = 0; i < curriList.size(); i++) {
			curriList.get(i).setCookNo(cookingclass);
		}
		cookingclass.setContentList(contentList);
		cookingclass.setCurriList(curriList);
		dao.insertClassTest(cookingclass);
	}

	@Override
	public void update(CookingClass cookingclass, CookingClassContent content, CookingClassCurriculum curriculum) {
		dao.updateClass(cookingclass);
		dao.updateContent(content);
		dao.updateCurriculum(curriculum);
	}

	@Override
	public CookingClass readClass(int cookNo) {
		return dao.readClass(cookNo);
	}

	@Override
	public List<CookingClassContent> readContent(int cookNo) {
		return dao.readContent(cookNo);
	}

	@Override
	public List<CookingClassCurriculum> readCurriculum(int cookNo) {
		return dao.readCurriculum(cookNo);
	}

	@Override
	public void insertImage(CookingClassImage image) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CookingClass> findTop5ByOrderByCount() {
		return dao.findTop5ByOrderByCount();
	}

	@Override
	public long countAll() {
		return dao.countAll();
	}

	@Override
	public List<CookingClass> selectByPageAndpagePerCount(int pageNo, String sort, String category) {
		List<CookingClass> list=null;
		if (category.equals("all")) {
			list = dao.selectBySort(pageNo,sort);
		} else {
			list = dao.selectBySortAndCategory(pageNo,sort,category);
		}
		return list;
	}

	@Override
	public void formInsert(CookingClassForm form) {
		form.getPayment().setCookFormNo(form);
		System.out.println("\n\n\n\n\n\n*************s");
		System.out.println(form);
		System.out.println(form.getUserId());
		System.out.println(form.getCookNo());
		System.out.println(form.getPayment());
		System.out.println("*************\n\n\n\n\n\n");
		dao.formInsert(form);
	}

	@Override
	public CookingClass findById(Integer cookNo) {
		return dao.findById(cookNo);
	}

	@Override
	public List<CookingClass> findByUserId(UserInfo userId) {
		return dao.findByUserId(userId);
	}

	@Override
	public List<CookingClass> classlistByPage(int pageNo, int pagePerCount, UserInfo user) {
		return dao.classlistByPage(pageNo, pagePerCount, user);
	}

	@Override
	public long countByUserId(UserInfo user) {
		return dao.countByUserId(user);

	}
	@Override
	public List<CookingClass> selectBySearch(int pageNo, String searchData, int pagePerCount) {

		return dao.selectBySearch(pageNo, searchData, pagePerCount);
	}
	@Override
	public long countByTitleContaining(String title) {
		return dao.countByTitleContaining(title);
	}
}
