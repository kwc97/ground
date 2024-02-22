package com.ground.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ground.dto.MemberDTO;
import com.ground.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	/*
	 * DI
	 * 
	 */
	@Autowired
	private MemberMapper memberMapper;
	
	/*
	 * INSERT
	 * 
	 */
	@Override
	public void insertMember( MemberDTO memberDTO) {
		
		memberMapper.insertMember( memberDTO );
	}
	
	
	@Override
    public boolean isIdDuplicate(String logId) {
        return memberMapper.getCountById(logId) > 0;
    }

    @Override
    public boolean isNicknameDuplicate(String nickname) {
        return memberMapper.isNicknameExists(nickname) > 0;
    }
	
	/*
	 * SelectMemberOne
	 * 
	 */
	@Override
	public MemberDTO getMemberOne( int user_id ) {
		
		return memberMapper.selectMemberOne( user_id );
	}
	
	
	/*
	 * UPDATE
	 * 
	 */
	@Override
	public void updateMember( MemberDTO memberDTO) {
		
		memberMapper.updateMember( memberDTO );
	}
	
	/*
	 *  SELECT MEMBER ALL
	 * 
	 */
	@Override
	public List<MemberDTO> getMemberList(){
		
		return memberMapper.selectMemberAll();		
	}
	
	/*
	 * DELETE MEMBER ONE
	 * 
	 */
	@Override
	public int deleteMember( int user_id ) {
		
		return memberMapper.deleteMemberOne( user_id );
	}
	
	@Override
	public String authenticateAsLogid(String user_name, String user_birth) {
	    MemberDTO memberDTO = new MemberDTO(user_name, user_birth);
	    String foundId = memberMapper.authenticateAsLogid(memberDTO);
	    if (foundId != null) {
	        return foundId; // 사용자의 ID를 반환합니다.
	    } else {
	        return "errorMsg"; // 에러 메시지를 반환합니다.
	    }
	}
	
	@Override
	public String authenticateAsLogPw(String log_id, String user_name, String user_birth) {
	    MemberDTO memberDTO = new MemberDTO();
	    memberDTO.setLog_id(log_id);
	    memberDTO.setUser_name(user_name);
	    memberDTO.setUser_birth(user_birth);
	    
	    String foundPw = memberMapper.authenticateAsLogPw(memberDTO);
	    
	    if (foundPw != null) {
	        return foundPw;
	    } else {
	        return "";
	    }
	}
	
   @Override
    public boolean isNickname(String nickname) {
	   return memberMapper.isNickname(nickname) > 0;
    }
   
   @Override
   public void PreviousNickname(MemberDTO memberDTO) {
	    // 이전 닉네임 설정
	    MemberDTO previousMember = memberMapper.selectMemberOne(memberDTO.getUser_id());
	    memberDTO.setPreviousNickname(previousMember.getNickname());

	    // 나머지 코드는 그대로 유지됩니다.
	    memberMapper.updateMember(memberDTO);
   }
}








