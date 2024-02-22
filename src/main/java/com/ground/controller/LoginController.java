package com.ground.controller;
	
	
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ground.dto.AccurDTO;
import com.ground.dto.MemberDTO;
import com.ground.service.LoginService;

import jakarta.servlet.http.HttpSession;
	
	
	
	
@Controller // 컨트롤러 빈으로 등록 
@RequestMapping("/login/*")
public class LoginController {

	/*
	 * DI
	 * 
	 */
	
	@Autowired
	private LoginService loginService;

	
	
	
	@GetMapping("/login/login")
	public String login(Model model) {
		model.addAttribute( "memberDTO", new MemberDTO() );
		
	  return "login/login";
}

    @PostMapping("/loginCheck")
    public String loginCheck(@RequestParam(value = "admin_account_or_log_id") String admin_account_or_log_id,
                             @RequestParam(value = "ad_pw_or_log_pw") String ad_pw_or_log_pw,
                             RedirectAttributes redirectAttributes,
                             Model model,
                             HttpSession session) {
       System.out.println("Received log_id_or_admin_account: " + admin_account_or_log_id);
        System.out.println("Received ad_pw: " + ad_pw_or_log_pw);
        
        // 아이디와 비밀번호가 빈 값인지 확인
        if (admin_account_or_log_id.isEmpty() || ad_pw_or_log_pw.isEmpty()) {
            model.addAttribute("message", "error");
            model.addAttribute("memberDTO", new MemberDTO()); // memberDTO 추가
            return "login/login";
        }
        
     // 관리자 로그인 확인
        String adminResult = loginService.authenticateAsAdmin(admin_account_or_log_id, ad_pw_or_log_pw);
        if ("success".equals(adminResult)) {
        	System.out.println("Admin login success");
            return "redirect:/member/memberList"; // 관리자 페이지로 이동
        }

        // 사용자 로그인 확인
        String userResult = loginService.authenticateAsUser(admin_account_or_log_id, ad_pw_or_log_pw);
        Integer user_id = loginService.loginCheck1(admin_account_or_log_id, ad_pw_or_log_pw);
        int ac_num = 0;
        System.out.println(userResult);
        System.out.println(user_id);
        if ("success".equals(userResult)) {
            ac_num = loginService.getAc_num(admin_account_or_log_id);
            System.out.println("ac_num: " + ac_num);
            if (ac_num == 0) {
                redirectAttributes.addFlashAttribute("log_id", admin_account_or_log_id);
                redirectAttributes.addFlashAttribute("user_id", user_id);
                session.setAttribute("log_id", admin_account_or_log_id);
                session.setAttribute("user_id", user_id);
        		System.out.println("User login success");
        		System.out.println("user_id :" + user_id);
                return "redirect:/mainpage/mainpage"; // 사용자 페이지로 이동
            }
        } else {
            model.addAttribute("message", "error");
            model.addAttribute("memberDTO", new MemberDTO());
            return "login/login";
        }
        // ac_num에 따른 처리
        if (ac_num == 1 || ac_num == 2 || ac_num == 3) {
            AccurDTO accurinfo = loginService.getAccurInfo(admin_account_or_log_id);
            Date updateDate = accurinfo.getUpdateDate();
            System.out.println("updateDate :" + updateDate);
            if (ac_num == 1) {
                // 3일 후의 날짜 계산
                Date threeDaysLater = new Date(updateDate.getTime() + (3 * 24 * 60 * 60 * 1000));
                Date now = new Date(); // 현재 시간
                if (now.after(threeDaysLater)) {
                    redirectAttributes.addFlashAttribute("log_id", admin_account_or_log_id);
                    redirectAttributes.addFlashAttribute("user_id", user_id);
                    return "redirect:/mainpage/mainpage"; // 사용자 페이지로 이동
                } else {
                    model.addAttribute("ac_num", ac_num);
                    model.addAttribute("acType", accurinfo.getAc_type());
                    model.addAttribute("acupdateDate", updateDate);
                    model.addAttribute("threeDaysLater", threeDaysLater);
                    model.addAttribute("postTitle", loginService.getTitle(loginService.getPost_id(admin_account_or_log_id)));
                    model.addAttribute("memberDTO", new MemberDTO());
                    return "login/login";
                }
            } else if (ac_num == 2) {
                // 7일 후의 날짜 계산
                Date sevenDaysLater = new Date(updateDate.getTime() + (7 * 24 * 60 * 60 * 1000));
                Date now = new Date(); // 현재 시간
                if (now.after(sevenDaysLater)) {
                    redirectAttributes.addFlashAttribute("log_id", admin_account_or_log_id);
                    redirectAttributes.addFlashAttribute("user_id", user_id);
                    return "redirect:/mainpage/mainPage"; // 사용자 페이지로 이동
                } else {
                    model.addAttribute("ac_num", ac_num);
                    model.addAttribute("acType", accurinfo.getAc_type());
                    model.addAttribute("acupdateDate", updateDate);
                    model.addAttribute("sevenDaysLater", sevenDaysLater);
                    model.addAttribute("postTitle", loginService.getTitle(loginService.getPost_id(admin_account_or_log_id)));
                    model.addAttribute("memberDTO", new MemberDTO());
                    return "login/login";
                }
            } else if (ac_num == 3) {
            	System.out.println("ac_num3=udateDate :" + updateDate);
            	model.addAttribute("acType", "3차 경고");
            	model.addAttribute("postTitle", "3번경고를 받았습니다");
                model.addAttribute("acupdateDate", updateDate);
                model.addAttribute("ac_num", ac_num);
                model.addAttribute("memberDTO", new MemberDTO());
                return "/login/login";
            }
        }model.addAttribute("memberDTO", new MemberDTO());
        return "login/login";
    }
}