package com.ground.dto;

public class PostLikeDTO {

	//Fields
	

	private int user_id;
	private int post_id;
	private boolean liked;

	
	// Getters and Setters
	

	public boolean isLiked() {
		return liked;
	}
	public void setLiked(boolean liked) {
		this.liked = liked;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	
	// toString
	
	@Override
	public String toString() {
		return "PostLikeDTO [user_id=" + user_id + ", post_id=" + post_id + ",liked=" + liked + "]";
	} 
	
	
	
	
	
}
