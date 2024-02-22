package com.ground.dto;

import java.util.Date;

public class AccurDTO {
	
		private int number;
		private int admin_id;
		private int user_id;
		private Integer post_id;
		private int mh_id;
		private String title;
		private String log_id;
		private String ac_type;
		private String cntent;
		private Date updateDate = new Date();
		private String admin_account_or_log_id;
		
		public AccurDTO() {
			
		}
		
	    public AccurDTO getAccurInfo() {
	        AccurDTO accurInfo = new AccurDTO();
			accurInfo.setAc_type(ac_type);
			accurInfo.setUpdateDate(updateDate);
			accurInfo.setPost_id(post_id);
			
	        return accurInfo;
	    }
	    	
		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public int getAdmin_id() {
			return admin_id;
		}

		public void setAdmin_id(int admin_id) {
			this.admin_id = admin_id;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public Integer getPost_id() {
			return post_id;
		}

		public void setPost_id(Integer post_id) {
			this.post_id = post_id;
		}

		public int getMh_id() {
			return mh_id;
		}

		public void setMh_id(int mh_id) {
			this.mh_id = mh_id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getLog_id() {
			return log_id;
		}

		public void setLog_id(String log_id) {
			this.log_id = log_id;
		}

		public String getAc_type() {
			return ac_type;
		}

		public void setAc_type(String ac_type) {
			this.ac_type = ac_type;
		}

		public String getCntent() {
			return cntent;
		}

		public void setCntent(String cntent) {
			this.cntent = cntent;
		}


		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
		
	    public String getAdmin_account_or_log_id() {
	        return admin_account_or_log_id;
	    }

	    public void setAdmin_account_or_log_id(String admin_account_or_log_id) {
	        this.admin_account_or_log_id = admin_account_or_log_id;
	    }

		@Override
		public String toString() {
			return "AccurDTO [number=" + number + ", admin_id=" + admin_id + ", user_id=" + user_id + ", post_id="
					+ post_id + ", mh_id=" + mh_id + ", title=" + title + ", log_id=" + log_id + ", ac_type=" + ac_type
					+ ", cntent=" + cntent +  ", updateDate=" + updateDate + "]";
		}

		
		
}
