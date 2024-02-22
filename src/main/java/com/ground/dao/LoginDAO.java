package com.ground.dao;

import java.util.Date;

import com.ground.dto.AccurDTO;
import com.ground.dto.LoginDTO;

public interface LoginDAO {
	
    public String loginCheck(LoginDTO dto);
    
    public String loginCheck1(LoginDTO dto);
    
    public String authenticateAsUser(LoginDTO dto);
    
    public String authenticateAsAdmin(LoginDTO dto);
    
    public AccurDTO getAccurInfo(AccurDTO dto);
    
    public int getAcNum(LoginDTO dto);	
    
    public String getAcType(AccurDTO dto);
    
    public Date getUpdateDate(AccurDTO dto);
    
    public Integer getPost_id(AccurDTO dto);
    
    public String getTitle(AccurDTO dto);
    
}