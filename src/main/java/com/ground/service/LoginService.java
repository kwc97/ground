package com.ground.service;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.ground.dto.AccurDTO;
import com.ground.dto.LoginDTO;


@Service
public interface LoginService {
	
	public String loginCheck(LoginDTO loginDTO);
    
	public String authenticateAsUser(String admin_account_or_log_id, String ad_pw_or_log_pw);
    
	public String authenticateAsAdmin(String admin_account_or_log_id, String ad_pw_or_log_pw);
	
	public Integer loginCheck1(@Param("admin_account_or_log_id") String admin_account_or_log_id, @Param("ad_pw_or_log_pw") String ad_pw_or_log_pw);
    
	public int getAc_num(String admin_account_or_log_id);
    
    public AccurDTO getAccurInfo(String admin_account_or_log_id);
    
    public String getAcType(String admin_account_or_log_id);
    
    public Date getUpdateDate(String admin_account_or_log_id);
    
    public Integer getPost_id(String admin_account_or_log_id);
    
    public String getTitle(Integer post_id);
    
}
