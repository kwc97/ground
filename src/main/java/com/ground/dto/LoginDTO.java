package com.ground.dto;

import java.util.Date;

public class LoginDTO {

	private Integer user_id;
	private String log_id;
	private String log_pw;
	private String user_name;
	private String admin_account;
	private String ad_pw;
	private String ad_nickname;
	private String ac_type;
	private int ac_num;
	private int post_id;
	private String title;
	private Date updateDate = new Date() ;
	

	
    public LoginDTO() {
    }
    
	public LoginDTO(String log_id, String log_pw, String admin_account, String ad_pw) {
        this.log_id = log_id;
        this.log_pw = log_pw;
		this.admin_account = admin_account;
		this.ad_pw = ad_pw;
    }
	
	public String getAdmin_account_or_log_id() {
	    return log_id != null ? log_id : admin_account;
	}
	
	public String getAd_pw_or_log_pw() {
	    return log_pw != null ? log_pw : ad_pw;
	}
	
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
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

	public String getAd_nickname() {
		return ad_nickname;
	}

	public void setAd_nickname(String ad_nickname) {
		this.ad_nickname = ad_nickname;
	}

	
	public String getAc_type() {
		return ac_type;
	}

	public void setAc_type(String ac_type) {
		this.ac_type = ac_type;
	}

	public int getAc_num() {
		return ac_num;
	}

	public void setAc_num(int ac_num) {
		this.ac_num = ac_num;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "LoginDTO [user_id=" + user_id + ", log_id=" + log_id + ", log_pw=" + log_pw + ", user_name=" + user_name
				+ ", admin_account=" + admin_account + ", ad_pw=" + ad_pw + ", ad_nickname=" + ad_nickname
				+ ", ac_type=" + ac_type + ", ac_num=" + ac_num + ", post_id=" + post_id + ", title=" + title
				+ ", updateDate=" + updateDate + "]";
	}


	
	
	
	
}