package com.ground.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ground.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "log_id")
	private String logId;
	
	private String log_pw;
	
	private String user_name;
	
	private String user_gender;
	
	private String user_birth;
	
	private String img_path;
	
	private String nickname;
	
	private String text;
	
	private Integer ac_num;
	
	@CreationTimestamp
	private LocalDateTime createDate = LocalDateTime.now();
	
	@UpdateTimestamp
	private LocalDateTime updateDate = LocalDateTime.now();
	
}
