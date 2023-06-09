package com.yorijori.foodcode.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yorijori.foodcode.jpa.entity.ChatInfo;


@Repository
public interface ChatInfoRepository extends JpaRepository<ChatInfo, Integer> { 
	
	@Query("SELECT c FROM ChatInfo c " + 
			"WHERE c.user1id = :userId "
			+ "OR c.user2id = :userId")
	List<ChatInfo> findAllRoomUserId(@Param(value="userId") String userId);
	
	@Query("SELECT c FROM ChatInfo c " + 
			"WHERE c.user1id = :userId "
			+ "AND c.user2id = :userId2")
	ChatInfo findRoomUserIdBoth(@Param(value="userId") String userId, @Param(value="userId2") String userId2);
	
	@Query("SELECT c FROM ChatInfo c " + 
			"WHERE c.user1id = :userId2 "
			+ "AND c.user2id = :userId")
	ChatInfo findRoomUserIdReverse(@Param(value="userId") String userId, @Param(value="userId2") String userId2);
}
	

	