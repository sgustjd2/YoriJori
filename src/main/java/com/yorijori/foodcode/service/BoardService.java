package com.yorijori.foodcode.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yorijori.foodcode.jpa.entity.Board;
import com.yorijori.foodcode.jpa.entity.UserInfo;

public interface BoardService {
	public Board insert(Board board);
	List<Board> selectAll();
	public Board boardUpdate(int commNo, Board board);
	void delete(int commNo);
	long countAll();
	List<Board> search();
	List<Board> search(String tag,String data);
	Page<Board> searchingBoardList(String keyword, Pageable pageable);
	List<Board> findByCategory(String category);
	Board select(int commNo);		
	List<Board> selectByPage(int pageNo);
	void bulletinBoardViews(int commNo);
	List<Board> selectByPageAndpagePerCount(int pageNo, int pagePerCount);		
	List<Board> selectByPageAndpagePerCountSearch(int pageNo, int pagePerCount,String contentKeyword);
	public long getCountByContentsAndState(String content);
	List<Board> selectByCategoryAndState(String category,int pageNo, int pagePerCount);
	public long getCountByCategorysAndState(String category);
	public List<Board> findmyboardlist(UserInfo user);
	long countByUserId(UserInfo user);
	List<Board> selectByPageByUser(int pageNo, int pagePerCount, UserInfo user);
	
	List<Long> countBycommNo(int startnum, int endnum);
	List<Board> selectByPageAndpagePerCount(int pageNo, int pagePerCount, int state);
	long countByState(int state);
	void update(Board board);

}
