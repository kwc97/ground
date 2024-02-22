package com.ground.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ground.dto.FollowDTO;
import com.ground.dto.MemberDTO;
import com.ground.dto.PostDTO;
import com.ground.service.MainPageService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;




@Controller // 컨트롤러 빈으로 등록 
@RequestMapping("/mainpage/*")
public class MainPageController {


	/*
	 * DI
	 * 
	 */
	@Autowired
	private MainPageService mainpageService;
	
		
	/*
	 * 회원 등록 Form 페이지 + 회원 수정 Form
	 * 
	 */
	@RequestMapping(value = "/mainpage/mainpage", method = {RequestMethod.GET, RequestMethod.POST})
	public String mainpage( 
			
            @ModelAttribute("log_id") String log_id,
            @ModelAttribute("user_id") int user_id,
			HttpServletRequest request,
			Model model ) {
		
			
			MemberDTO m1 = mainpageService.getMemberOne(log_id);
			List<PostDTO> posts = mainpageService.getAllPosts( user_id );			
			for (PostDTO post : posts) {
			    MemberDTO member = mainpageService.getMemberOne2(post.getMh_id());
			    post.setMember(member);
			}
			int m2 = mainpageService.getFollowingNum( user_id );
			int m3 = mainpageService.getFollowNum( user_id );
			
			// 잘 되는지 콘솔에 출력
			
			
			// Form 페이지로 m1 객체를 전달 --> 모델(model)
			model.addAttribute( "memberDTO", m1 );			
			model.addAttribute("followingnum", m2);
			model.addAttribute("follownum", m3);		
			model.addAttribute("posts", posts);
			

			return "mainpage/mainpage";
	}
	
	@GetMapping("/mainpage/seclogin")
	public String seclogin(@RequestParam("log_id") String log_id,						   
            RedirectAttributes redirectAttributes,
            Model model) {


		System.out.println("log_id1 : "+log_id);
		
		model.addAttribute("log_id", log_id);
		
		
		
		return "mainpage/seclogin";
		}

	@PostMapping("/mainpage/seclogincheck")
	public String seclogincheck(@RequestParam("log_id") String log_id,
	            @RequestParam("log_pw") String log_pw,
	            RedirectAttributes redirectAttributes,
	            Model model) {

		MemberDTO m1 = mainpageService.getMemberOne(log_id);
		System.out.println("mainpage log_id2 : " + m1);
		// 입력된 비밀번호가 m1의 비밀번호와 일치하는지 확인
		if (m1 != null && m1.getLog_pw().equals(log_pw)) {
		// 비밀번호가 일치하면 editinfo.html로 이동
			return "redirect:/mainpage/editinfo?log_id=" + log_id + "&user_id=" + m1.getUser_id();
		} else {
		// 비밀번호가 일치하지 않으면 mainpage/mainpage로 리디렉션
		redirectAttributes.addAttribute("log_id", log_id);
		redirectAttributes.addAttribute("user_id",  m1.getUser_id());
		return "redirect:/mainpage/mainpage";
		}
	}


@GetMapping("mainpage/editinfo")
public String editInfo(@RequestParam("log_id") String log_id,
			   @RequestParam("user_id") int user_id,
            RedirectAttributes redirectAttributes,
            Model model) {
// 컨트롤러에서 받은 정보를 활용하여 원하는 작업 수행
// ...

MemberDTO m1 = mainpageService.getMemberOne(log_id);
int m2 = mainpageService.getFollowingNum( user_id );
int m3 = mainpageService.getFollowNum( user_id );

// 모델에 필요한 데이터를 추가
model.addAttribute( "memberDTO", m1 );
model.addAttribute("followingnum", m2);
model.addAttribute("follownum", m3);

System.out.println("log_id : " + log_id);


// 결과를 보여줄 뷰의 이름 반환
return "mainpage/editinfo"; // editinfo는 뷰의 이름으로 변경해야 합니다.
}


@GetMapping("/mainpage/follow")
public String follow(@RequestParam("user_id") int user_id,						   
            RedirectAttributes redirectAttributes,
            Model model) {

	List<FollowDTO> followers = mainpageService.getAllFollows2( user_id );
	for (FollowDTO follower : followers) {
	MemberDTO member = mainpageService.getMemberOne3(follower.getUser_id());			
	follower.setMember(member);
	}
	
	List<FollowDTO> follows = mainpageService.getAllFollows( user_id );
	for (FollowDTO follow : follows) {
		MemberDTO member = mainpageService.getMemberOne3(follow.getF_user_id());			
		follow.setMember(member);
	}
	
	System.out.println("user_id1 : "+user_id);
	
	model.addAttribute("user_id", user_id);	    
	model.addAttribute("follows", follows);
	model.addAttribute("followers", followers);	    
	
	return "mainpage/follow";
}



@GetMapping("/mypage")
public String myPageFromMainPage(HttpSession session, Model model) {
    // 세션에서 로그인 정보 가져오기
    String log_id = (String) session.getAttribute("log_id");
    if (log_id != null) {
        // 세션에 로그인 정보가 있을 때만 처리
        return "redirect:/mypage?log_id=" + log_id;
    } else {
        // 세션에 로그인 정보가 없으면 로그인 페이지로 리다이렉트 또는 다른 처리
        return "redirect:/login/login";
    }
}
/*
 * @GetMapping("/mainpage/likecount")
 * 
 * @ResponseBody public ResponseEntity<Integer> getLikeCount(
 * 
 * @RequestParam("post_id") String postId) {
 * 
 * try { int post_id = Integer.parseInt(postId); int likeCount =
 * mainpageService.getPostNum(post_id);
 * 
 * // 좋아요 수를 정상적으로 반환 return ResponseEntity.ok(likeCount); } catch (Exception e)
 * { // 좋아요 수를 가져오는 중 에러가 발생하면 실패로 응답 return
 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1); } }
 * 
 * 
 * @PostMapping("/mainpage/like")
 * 
 * @ResponseBody public ResponseEntity<Integer> likePost(
 * 
 * @RequestParam("post_id") String postId,
 * 
 * @RequestParam("user_id") String userId, Model model) {
 * 
 * try { int post_id = Integer.parseInt(postId); int user_id =
 * Integer.parseInt(userId);
 * 
 * // 좋아요 처리 비즈니스 로직을 서비스에서 처리 mainpageService.likePost(post_id, user_id); int
 * updatedLikeCount = mainpageService.getPostNum(post_id);
 * 
 * // 좋아요 수를 정상적으로 반환 return ResponseEntity.ok(updatedLikeCount); } catch
 * (Exception e) { // 좋아요 처리 중 에러가 발생하면 실패로 응답 return
 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1); // 실패 시 -1을
 * 반환하거나 다른 방식으로 실패 처리 } }
 */



}

