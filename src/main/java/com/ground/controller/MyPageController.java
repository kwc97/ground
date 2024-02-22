package com.ground.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ground.dto.MemberDTO;
import com.ground.entity.Post;
import com.ground.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String myPage(HttpSession session, Model model) {
        String logId = (String) session.getAttribute("log_id");
        if (logId != null) {
        	// UserService를 사용하여 현재 로그인한 사용자의 정보를 가져옴
            MemberDTO memberDTO = userService.getMemberDTOByLogId(logId);
            model.addAttribute("memberDTO", memberDTO); // 모델에 사용자 정보 추가

            
            List<Post> userPosts = userService.getPostsByLogId(logId);
            model.addAttribute("userPosts", userPosts); // 모델에 사용자 게시물 추가
            return "mypage/mypage";
        } else {
            return "redirect:/login/login";
        }
    }
    
    @GetMapping("/search")
    public String searchUserPosts(@RequestParam("log_id") String logId, @RequestParam("searchKeyword") String searchKeyword, Model model) {
        List<Post> userPosts = userService.searchUserPosts(logId, searchKeyword);
        model.addAttribute("userPosts", userPosts);
        return "mypage/mypage";
    }
    
    
}
