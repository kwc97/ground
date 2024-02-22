package com.ground.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ground.entity.Home;

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
public class Home {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer mh_id;

	private String introduce;
	
	private Integer total;

	private Integer today;
	
	private String mh_url;
	
	@CreationTimestamp
	private LocalDateTime createDate = LocalDateTime.now();
	
	@UpdateTimestamp
	private LocalDateTime updateDate = LocalDateTime.now();
	
	@ManyToOne
    @JoinColumn(name = "user_id") // 외래 키의 이름을 지정
    private Member member;

}
