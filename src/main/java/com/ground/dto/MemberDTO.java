package com.ground.dto;

import java.util.Date;

public class MemberDTO {

    // Fields
    private int user_id;
    private String log_id;
    private String log_pw;
    private String user_name;
    private String user_gender;
    private String user_birth;
    private String img_path;
    private String nickname;
    private String text;
    private int ac_num;
    private String admin_account;
    private String ad_pw;
    private Date createDate = new Date();
    private Date updateDate = new Date();
    private String emailDomain; // 도메인
    private String admin_account_or_log_id;
    private String ad_pw_or_log_pw;
    private String previousNickname;

    // Constructors
    public MemberDTO() {
    }
  
    
    public MemberDTO(String user_name, String user_birth) {
        this.user_name = user_name;
        this.user_birth = user_birth;
    }


    // Getters and Setters
    public String getEmailDomain() {
        return emailDomain;
    }

    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    public String getAdmin_account_or_log_id() {
        return log_id != null ? log_id : admin_account_or_log_id;
    }

    public void setAdmin_account_or_log_id(String admin_account_or_log_id) {
        this.admin_account_or_log_id = admin_account_or_log_id;
    }

    public String getAd_pw_or_log_pw() {
        return log_pw != null ? log_pw : ad_pw_or_log_pw;
    }

    public void setAd_pw_or_log_pw(String ad_pw_or_log_pw) {
        this.ad_pw_or_log_pw = ad_pw_or_log_pw;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getLog_pw() {
        return log_pw;
    }

    public void setLog_pw(String log_pw) {
        this.log_pw = log_pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAc_num() {
        return ac_num;
    }

    public void setAc_num(int ac_num) {
        this.ac_num = ac_num;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAdmin_account() {
        return admin_account;
    }

    public void setAdmin_account(String admin_account) {
        this.admin_account = admin_account;
    }

    public String getAd_pw() {
        return ad_pw;
    }

    public void setAd_pw(String ad_pw) {
        this.ad_pw = ad_pw;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date date) {
        this.createDate = date;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    public void setUserNameAndBirth(String user_name, String user_birth) {
        this.user_name = user_name;
        this.user_birth = user_birth;
    }
    
    public void setLogIdAndUserNameAndBirth(String log_id, String user_name, String user_birth) {
        this.log_id = log_id;
    	this.user_name = user_name;
        this.user_birth = user_birth;
    }
    
    public String getPreviousNickname() {
        return previousNickname;
    }

    public void setPreviousNickname(String previousNickname) {
        this.previousNickname = previousNickname;
    }


	@Override
	public String toString() {
		return "MemberDTO [user_id=" + user_id + ", log_id=" + log_id + ", log_pw=" + log_pw + ", user_name="
				+ user_name + ", user_gender=" + user_gender + ", user_birth=" + user_birth + ", img_path=" + img_path
				+ ", nickname=" + nickname + ", text=" + text + ", ac_num=" + ac_num + ", admin_account="
				+ admin_account + ", ad_pw=" + ad_pw + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", emailDomain=" + emailDomain + ", admin_account_or_log_id=" + admin_account_or_log_id
				+ ", ad_pw_or_log_pw=" + ad_pw_or_log_pw + ", previousNickname=" + previousNickname + "]";
	}
    
    

}
