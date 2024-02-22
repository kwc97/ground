package com.ground.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ground.dto.AccurDTO;
import com.ground.dto.LoginDTO;
import com.ground.mapper.LoginMapper;



@Service // service bean으로 등록
public class LoginServiceImpl implements LoginService {

    private final LoginMapper loginMapper;

    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper) { // 생성자에 LoginDAO 추가
        this.loginMapper = loginMapper;
    }

    @Override
    public String loginCheck(LoginDTO loginDTO) {
        return loginMapper.loginCheck(loginDTO);
    }
    
    @Override
    public Integer loginCheck1(String admin_account_or_log_id, String ad_pw_or_log_pw) {
        LoginDTO loginDTO = new LoginDTO(admin_account_or_log_id, ad_pw_or_log_pw, null, null);
        Integer result = loginMapper.loginCheck1(loginDTO);
        return (result != null) ? result : -1;
    }
    
    @Override	
    public String authenticateAsUser(String admin_account_or_log_id, String ad_pw_or_log_pw) {
        LoginDTO loginDTO = new LoginDTO(admin_account_or_log_id, ad_pw_or_log_pw, null, null);
        String result = loginMapper.authenticateAsUser(loginDTO);
        return (result != null) ? "success" : "error";
    }

    @Override
    public String authenticateAsAdmin(String admin_account_or_log_id, String ad_pw_or_log_pw) {
        LoginDTO loginDTO = new LoginDTO(admin_account_or_log_id, ad_pw_or_log_pw, null, null);
        String result = loginMapper.authenticateAsAdmin(loginDTO);
        return (result != null) ? "success" : "error";
    }
    
    @Override
    public int getAc_num(String admin_account_or_log_id) {
        LoginDTO loginDTO = new LoginDTO(admin_account_or_log_id, null, null, null);
        return loginMapper.getAc_num(loginDTO);
    }
    
    
    @Override
    public AccurDTO getAccurInfo(String admin_account_or_log_id) {
        // AccurDTO 객체 생성
        AccurDTO accurDTO = new AccurDTO();
        // admin_account_or_log_id를 설정
        accurDTO.setAdmin_account_or_log_id(admin_account_or_log_id);
        // loginMapper에서 getAccurInfo 메서드를 호출하고 결과를 반환합니다.
        return loginMapper.getAccurInfo(accurDTO);
    }
    @Override
    public String getAcType(String admin_account_or_log_id) {
        // 생성자를 사용하여 AccurDTO 객체 생성
        AccurDTO accurDTO = new AccurDTO();
        accurDTO.setAc_type(admin_account_or_log_id);
        return loginMapper.getAcType(accurDTO);
    }

    @Override
    public Date getUpdateDate(String admin_account_or_log_id) {
        // 생성자를 사용하여 AccurDTO 객체 생성
        AccurDTO accurDTO = new AccurDTO();
        accurDTO.setAc_type(admin_account_or_log_id);
        return loginMapper.getUpdateDate(accurDTO);
    }

    @Override
    public Integer getPost_id(String admin_account_or_log_id) {
        AccurDTO accurDTO = new AccurDTO(); // AccurDTO 생성
        accurDTO.setAdmin_account_or_log_id(admin_account_or_log_id); // 매개변수로 받은 값을 설정
        
        Integer postId = loginMapper.getPost_id(accurDTO); // LoginMapper에서 post_id를 가져옵니다.
        return postId != null ? postId : 0; // 기본값을 0으로 설정합니다.
    }
    
    @Override
    public String getTitle(Integer post_id) {
        AccurDTO accurDTO = new AccurDTO();
        accurDTO.setPost_id(post_id);
        return loginMapper.getTitle(accurDTO);
    }
}