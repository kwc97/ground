package com.ground.mapper;


import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

import com.ground.dto.AccurDTO;
import com.ground.dto.LoginDTO;


@Mapper
public interface LoginMapper {
	
    public String loginCheck(LoginDTO loginDTO);
    
    public String authenticateAsUser(LoginDTO loginDTO); // 변경된 반환 타입
    
    public String authenticateAsAdmin(LoginDTO loginDTO); // 변경된 반환 타입
    
    public Integer loginCheck1(LoginDTO loginDTO);
    
    public int getAc_num(LoginDTO loginDTO);	
    
    public AccurDTO getAccurInfo(AccurDTO accurDTO);
    
    public String getAcType(AccurDTO accurDTO);
    
    public Date getUpdateDate(AccurDTO accurDTO);
    
    public Integer getPost_id(AccurDTO accurDTO);
    
    public String getTitle(AccurDTO accurDTO);
}