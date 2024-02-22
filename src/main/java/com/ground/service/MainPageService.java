package com.ground.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ground.dto.FollowDTO;
import com.ground.dto.MemberDTO;
import com.ground.dto.PostDTO;

@Service
public interface MainPageService {
	
	public List<PostDTO> getAllPosts(int user_id );
	
	public MemberDTO getMemberOne(String log_id);

	public MemberDTO getMemberOne2(int mh_id);
	
	public int getFollowingNum(int user_id);
	
	public int getFollowNum(int user_id);
	
	public void likePost(int post_id, int user_id);
	
	public int getPostNum(int post_id);
	
	public FollowDTO getFollowOne(int user_id);
	
	public List<FollowDTO> getAllFollows(int user_id );
	
	public MemberDTO getMemberOne3(int user_id);
	
	public List<FollowDTO> getAllFollows2(int user_id);
}

