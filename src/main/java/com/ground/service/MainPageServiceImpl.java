package com.ground.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ground.dto.FollowDTO;
import com.ground.dto.MemberDTO;
import com.ground.dto.PostDTO;
import com.ground.mapper.MainPageMapper;

@Service
public class MainPageServiceImpl implements MainPageService{
	
	/*
	 * DI
	 * 
	 */

	
	@Autowired
	private MainPageMapper mainpageMapper;
	
	
	@Override
	public List<PostDTO> getAllPosts(int user_id){
		return mainpageMapper.getAllPosts(user_id);
	}
	
	
	@Override
	public int getFollowingNum(int user_id) {
		
		return mainpageMapper.selectFollowingNum(user_id);
	}
	
	@Override
	public int getFollowNum(int user_id) {
		
		return mainpageMapper.selectFollowNum(user_id);
	}
	/*
	 * SelectMemberOne
	 * 
	 */
	@Override
	public MemberDTO getMemberOne(String log_id) {
		
		return mainpageMapper.selectMemberOne(log_id);
	}
	
	@Override
	public MemberDTO getMemberOne2(int mh_id) {
		
		return mainpageMapper.selectMemberOne2(mh_id);
	}
	
	@Override
    public void likePost(int post_id, int user_id) {
        mainpageMapper.insertLike(post_id, user_id);
    }
	
	@Override
    public int getPostNum(int post_id) {
        return mainpageMapper.selectPostNum(post_id);
    }
	
	@Override
	public FollowDTO getFollowOne(int user_id) {
		
		return mainpageMapper.selectFollowOne(user_id);
	}
	
	@Override
	public List<FollowDTO> getAllFollows(int user_id){
		return mainpageMapper.getAllFollows(user_id);
	}
	
	@Override
	public MemberDTO getMemberOne3(int user_id) {
		
		return mainpageMapper.selectMemberOne3(user_id);
	}
	
	@Override
	public List<FollowDTO> getAllFollows2(int user_id){
		return mainpageMapper.getAllFollows2(user_id);
	}
	

}
