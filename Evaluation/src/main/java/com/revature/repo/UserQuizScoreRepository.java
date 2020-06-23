package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.UserQuizScore;

@Repository
public interface UserQuizScoreRepository extends JpaRepository<UserQuizScore, Long>, CrudRepository<UserQuizScore, Long> {
	
	public List<UserQuizScore> findUserQuizScoreByUserId(long userId);
}
