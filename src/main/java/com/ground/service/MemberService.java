package com.ground.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ground.dto.MemberDTO;

@Service
public interface MemberService {
	
	public void insertMember( MemberDTO memberDTO);
	
	public boolean isIdDuplicate(String logId);
	
    public boolean isNicknameDuplicate(String nickname);
	
	public MemberDTO getMemberOne( int user_id);
	
	public void updateMember(MemberDTO memberDTO);
	
	public List<MemberDTO> getMemberList();
	
	public int deleteMember( int user_id );
	
	public String authenticateAsLogid(String user_name, String user_birth);

	public String authenticateAsLogPw(String log_id, String user_name, String user_birth);
	
	public boolean isNickname(String nickname);

	public void PreviousNickname(MemberDTO memberDTO);
}
