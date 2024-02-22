package com.ground.dto;

import java.util.Date;
import java.util.List;

public class PostDTO {

	//Fields
	
	private int post_id;
	private int mh_id;
	private String title;
	private String cntent;
	private String hash_tag;
	private String url_path;
	private String img_path;
	private Date createDate = new Date(); 
	private Date updateDate = new Date();
	private MemberDTO member;
	private List<PostLikeDTO> liked;

    
	
	//Getters and Setters
	
	public void setPostLike(List<PostLikeDTO> liked) {
        this.liked = liked;
    }
	
	public List<PostLikeDTO> getPost_like() {
		return liked;
	}

	public void setPost_like(List<PostLikeDTO> liked) {
		this.liked = liked;
	}

	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
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
	public String getCntent() {
		return cntent;
	}
	public void setCntent(String cntent) {
		this.cntent = cntent;
	}
	public String getHash_tag() {
		return hash_tag;
	}
	public void setHash_tag(String hash_tag) {
		this.hash_tag = hash_tag;
	}
	public String getUrl_path() {
		return url_path;
	}
	public void setUrl_path(String url_path) {
		this.url_path = url_path;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
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
	
	public MemberDTO getMember() {
	       return member;
	   }

	public void setMember(MemberDTO member) {
	    this.member = member;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "PostDTO [post_id=" + post_id + ", mh_id=" + mh_id + ", title=" + title + ", cntent=" + cntent
				+ ", hash_tag=" + hash_tag + ", url_path=" + url_path + ", img_path=" + img_path + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
	
	
	
}
