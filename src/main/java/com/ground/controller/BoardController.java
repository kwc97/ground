package com.ground.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ground.entity.Post;
import com.ground.repository.BoardRepository;
import com.ground.service.BoardService;
import com.ground.service.UserService;

import jakarta.persistence.Id;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/write")
	public String boardWriteForm() {
		
		return "/board/boardwrite";
		 
	}
	
	@PostMapping("/board/writepro") 
	public String boardWritePro(Post post, Model model, MultipartFile file) throws Exception {
		
		if (post.getTitle() == null || post.getTitle().isEmpty()) {
	        model.addAttribute("message", "제목을 입력하세요.");
	        model.addAttribute("searchUrl", "/board/write");
	        return "/board/message";
	    } if (post.getCntent() == null || post.getCntent().isEmpty()) {
	        model.addAttribute("message", "내용을 입력하세요.");
	        model.addAttribute("searchUrl", "/board/write");
	        return "/board/message";
	    } if (file == null || file.isEmpty()) {
	        model.addAttribute("message", "파일을 등록하세요.");
	        model.addAttribute("searchUrl", "/board/write");
	        return "/board/message";
	    }

	    boardService.write(post, file);

	    model.addAttribute("message", "글 작성이 완료되었습니다.");
	    model.addAttribute("searchUrl", "/board/list");

	    return "/board/message";

	}
	
	@GetMapping("/board/list")
	public String boardList(Model model, @PageableDefault(page = 0, size = 6, sort = "postId", direction = Sort.Direction.DESC) 
							Pageable pageable, String searchKeyword, Integer mh_id) {
		
		Page<Post> list = null;
		
//		if(searchKeyword == null) {
//            list = boardService.boardList(pageable);
//        } else {
//            list = boardService.boardSearchList(searchKeyword, pageable);
//        }
		
		int blockLimit = 5;
		int nowPage = list.getPageable().getPageNumber() + 1;

		int startPage = ((nowPage - 1) / blockLimit) * blockLimit + 1;
	    int endPage = Math.min(startPage + blockLimit - 1, list.getTotalPages());
	    

		model.addAttribute("list", list);
		model.addAttribute("blockLimit", blockLimit);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "/board/boardlist";
		
	}
	
	@GetMapping("/board/view")
	public String boardView(Model model, Integer id) {
		
		model.addAttribute("post", boardService.boardView(id));
		return "/board/boardview";
		
	}
	
	// 작성시간
	@PostMapping("/board/view")
	public String create_date(Post post, Model model) {
		boardService.savePostwithCurrentTime(post);
		return "redirect:/board/view";
	}

	@GetMapping("/board/delete")
	public String boardDelete(Integer id, Model model) {
		
		boardService.boardDelete(id);
		
		// 삭제완료 메시지창
        model.addAttribute("message", "삭제가 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

        return "/board/message";
	}
	
	@GetMapping("/board/modify/{id}")
	public String boardModify(@PathVariable("id") Integer id, Post post, Model model, MultipartFile file) throws Exception {
		
		model.addAttribute("post", boardService.boardView(id));
		
		return "/board/boardmodify";
	}
	
	@PostMapping("/board/update/{id}")
	public String boardUpdate(@PathVariable("id") Integer id, Post post, MultipartFile file, Model model) throws Exception {
	
	    if (post.getTitle() == null || post.getTitle().isEmpty()) {
	        model.addAttribute("message", "제목을 입력하세요.");
	        model.addAttribute("searchUrl", "/board/modify/" +id);
	        return "/board/message";
	    } if (post.getCntent() == null || post.getCntent().isEmpty()) {
	        model.addAttribute("message", "내용을 입력하세요.");
	        model.addAttribute("searchUrl", "/board/modify/" +id);
	        return "/board/message";
	    } if (file == null || file.isEmpty()) {
	        model.addAttribute("message", "파일을 등록하세요.");
	        model.addAttribute("searchUrl", "/board/modify/" +id);
	        return "/board/message";
	    } 
	    
	    Post postTemp = boardService.boardView(id);
	    
	    postTemp.setTitle(post.getTitle());
	    postTemp.setCntent(post.getCntent());
	    postTemp.setImg_path(post.getImg_path());
	    postTemp.setHash_tag(post.getHash_tag());
	    postTemp.setUpdate_date(LocalDateTime.now());

	   
	    boardService.updatePost(postTemp);
	    boardService.write(postTemp, file);

	    // 수정완료 메시지창
	    model.addAttribute("message", "수정이 완료되었습니다.");
	    model.addAttribute("searchUrl", "/board/list");

	    return "/board/message";
	}

	
	
}
