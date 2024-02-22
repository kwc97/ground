package com.ground.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ground.dto.FollowDTO;
import com.ground.dto.MemberDTO;
import com.ground.dto.PostDTO;

@Mapper
public interface MainPageMapper {

	
	public List<PostDTO> getAllPosts(int user_id);
	public int selectFollowingNum(int user_id);
	public int selectFollowNum(int user_id);
	public MemberDTO selectMemberOne(String log_id);
	public MemberDTO selectMemberOne2(int mh_id);
	public void insertLike(int post_id, int user_id);
	public int selectPostNum(int post_id);
	public FollowDTO selectFollowOne(int user_id);
	public List<FollowDTO> getAllFollows(int user_id);
	public MemberDTO selectMemberOne3(int user_id);
	public List<FollowDTO> getAllFollows2(int user_id);
}