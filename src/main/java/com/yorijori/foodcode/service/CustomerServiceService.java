package com.yorijori.foodcode.service;

import java.util.List;

import com.yorijori.foodcode.jpa.entity.Inquiry;
import com.yorijori.foodcode.jpa.entity.InquiryComment;
import com.yorijori.foodcode.jpa.entity.Notice;
import com.yorijori.foodcode.jpa.entity.Question;
import com.yorijori.foodcode.jpa.entity.UserInfo;

public interface CustomerServiceService {
	public	Notice	noticeInsert(Notice	notice);
	
	List<Notice> selectAll();
	
	long noticeCountAll();
	
	List<Notice> selectByPageAndpagePerCount(int pageNo,int pagePerCount );

	public void noticeDelete(int noticeNo);

	
	//자주 묻는 질문
	
	public	Question	questionInsert(Question question);
	
	long questionCountAll();
	
	List<Question> questionSelectByPageAndpagePerCount(int pageNo,int pagePerCount );

	public void questionDelete(int questionNo);
	
	//문의하기
	
	public	Inquiry	inquiryInsert(Inquiry  inquiry);
	
	long inquiryCountAll();
	
	List<Inquiry> inquirySelectByPageAndpagePerCount(int pageNo,int pagePerCount );
	
	public void inquiryDelete(int inquiryNo);
	
	List<Inquiry> findByUserId(UserInfo user);

	Inquiry select(int inquiryNo);
	
	List<Inquiry> getAllInquiries();

	
	//문의하기 댓글
	
	public	InquiryComment	inquiryCommentInsert(InquiryComment  inquiryComment);
	
	List<InquiryComment> inquiryCommentList(int inquiryNo);	

	public InquiryComment inquiryCommentDelete(int id);
	
	public List<InquiryComment> getInquiryCommentsByState(int inquiryNo, int state);

	

}
