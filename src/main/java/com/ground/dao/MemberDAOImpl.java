package com.ground.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ground.dto.MemberDTO;


@Repository // 현재 클래스를 dao bean으로 등록
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession; // SqlSession 의존관계 주입
	
	@Override
	public String loginCheck(MemberDTO dto) {
	return sqlSession.selectOne("login_check", dto);
	 }
}