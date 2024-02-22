package com.ground.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ground.entity.Post;

@Repository
public interface BoardRepository extends JpaRepository<Post, Integer>{
	
	List<Post> findByHomeMemberUserIdAndTitleContaining(Integer userId, String searchKeyword);
	List<Post> findByHomeMemberUserId(Integer userId);
//	Page<Post> findByTitleContaining(String searchKeyword, Pageable pageable);
	
}
