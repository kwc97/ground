package com.ground.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ground.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	public void insertMember( MemberDTO memberDTO );
	
	public int getCountById(@Param("logId") String logId);
	
    public int getCountByNickname(@Param("nickname") String nickname);
	
	
	public MemberDTO selectMemberOne( int user_id);
	
	public void updateMember( MemberDTO memberDTO );
	
	public List<MemberDTO> selectMemberAll();
	
	public int deleteMemberOne( int user_id);

	public String authenticateAsLogid(MemberDTO memberDTO);

	public String authenticateAsLogPw(MemberDTO memberDTO);

	public int isNickname(String nickname);

	public int isNicknameExists(String nickname);
}
