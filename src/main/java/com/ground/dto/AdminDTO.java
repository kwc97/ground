package com.ground.dto;

import java.util.Date;

public class AdminDTO {

	// Fields
		private int admin_id;
		private String admin_account;
		private String ad_pw;
		private String ad_nickname;
		private Date createDate = new Date() ; 
		private Date updateDate = new Date() ;
		
		// Constructors
		public AdminDTO() {
		}
		
		public AdminDTO(String admin_account, String ad_pw) {
	        this.admin_account = admin_account;
	        this.ad_pw = ad_pw;
	    }

		//Getters and Setters
		public int getAdmin_id() {
			return admin_id;
		}

		public void setAdmin_id(int admin_id) {
			this.admin_id = admin_id;
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

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
		
	// toString
		@Override
		public String toString() {
			return "AdminDTO [admin_id=" + admin_id + ", admin_account=" + admin_account + ", ad_pw="
					+ ad_pw + ", ad_nickname=" + ad_nickname + ", createDate=" + createDate + ", updateDate="
					+ updateDate + "]";
		}
		
		
		
}
