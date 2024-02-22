
package com.ground.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ground.entity.Post;
import com.ground.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 글 작성 처리
	public void write(Post post, MultipartFile file) throws Exception{
		
		String projectPath = System.getProperty("user.dir") + "\\src\\main\\webapp";
		
		UUID uuid = UUID.randomUUID();
		
		String img_path = uuid + "_" + file.getOriginalFilename();
		
		File saveFile = new File(projectPath, img_path);
		
		file.transferTo(saveFile);
		
		post.setImg_path("/webapp/" + img_path);
		
		boardRepository.save(post);
	}
	
	// 게시글 작성 시간
	public void savePostwithCurrentTime(Post post) {
		post.setCreate_date(LocalDateTime.now());
		boardRepository.save(post);
	}
	
	// 게시글 수정 시간
	public void updatePost(Post post) {
		post.setUpdate_date(LocalDateTime.now());
		boardRepository.save(post);
	}
	
	// 게시글 리스트 처리
	public Page<Post> boardList(Pageable pageable) {
		
		return boardRepository.findAll(pageable);
	}
	
	// 검색
//	public Page<Post> boardSearchList(String searchKeyword, Pageable pageable) {
//
//        return boardRepository.findByTitleContaining(searchKeyword, pageable);
//
//    }
	
	
	// 특정 게시글 불러오기 
	public Post boardView(Integer id) {
		
		return boardRepository.findById(id).get();
	}
	
	// 특정 게시글 삭제
	public void boardDelete(Integer id) {
		boardRepository.deleteById(id);
	}
	
}