package com.ground.dao;

import java.util.Date;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ground.dto.AccurDTO;
import com.ground.dto.LoginDTO;

@Repository
public class LoginDAOImpl implements LoginDAO {

    @Inject
    private SqlSession sqlSession;

    @Override
    public String loginCheck(LoginDTO dto) {
        return sqlSession.selectOne("login_check", dto);
    }
    
    @Override
    public String loginCheck1(LoginDTO dto) {
        return sqlSession.selectOne("login_check1", dto);
    }

    @Override
    public String authenticateAsUser(LoginDTO dto) {
        return sqlSession.selectOne("authenticateAsUser", dto);
    }

    @Override
    public String authenticateAsAdmin(LoginDTO dto) {
        return sqlSession.selectOne("authenticateAsAdmin", dto);
    }
    
    @Override
    public int getAcNum(LoginDTO dto) {
        return sqlSession.selectOne("getAcNum", dto);
    }
    
    @Override
    public AccurDTO getAccurInfo(AccurDTO dto) {
        return sqlSession.selectOne("getAccurInfo", dto);
    }
    
    @Override
    public String getAcType(AccurDTO dto) {
        return sqlSession.selectOne("getAcType", dto);
    }
    
    @Override
    public Date getUpdateDate(AccurDTO dto) {
        return sqlSession.selectOne("getUpdateDate", dto);
    }
    
    @Override
    public Integer getPost_id(AccurDTO dto) {
        return sqlSession.selectOne("getPost_id", dto);
    }
    
    @Override
    public String getTitle(AccurDTO dto) {
        return sqlSession.selectOne("getTitle", dto);
    }
    
    
}