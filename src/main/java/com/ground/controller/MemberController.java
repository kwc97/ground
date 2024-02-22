package com.ground.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ground.dto.MemberDTO;
import com.ground.service.MemberService;




@Controller // 컨트롤러 빈으로 등록 
@RequestMapping("/member/*")
public class MemberController {


	/*
	 * DI
	 * 
	 */
	@Autowired
	private MemberService memberService;
	

	
	/*
	 * 회원 등록 Form 페이지 + 회원 수정 Form
	 * 
	 */
	@GetMapping("/member/memberWriteFormNew")
	public String memberWriteForm( 
			@RequestParam( value="user_id", required=false ) Integer user_id,
			Model model ) {
		
		if( user_id != null ) {
			
			System.out.println( user_id );
			MemberDTO m1 = memberService.getMemberOne( user_id );
			
			if( m1 == null ) {
				
				model.addAttribute( "msg", "회원 정보가 없습니다. 메인 페이지로 이동합니다." );
				model.addAttribute( "url", "/" );
				
				return "member/messageAlert";  // messageAlert.html
			}
			
			// 잘 되는지 콘솔에 출력
			System.out.println( m1.getUser_name() );
			System.out.println( m1.getLog_id() );
			System.out.println( m1.getUser_gender() );
			
			// Form 페이지로 m1 객체를 전달 --> 모델(model)
			model.addAttribute( "memberDTO", m1 );
			model.addAttribute( "formTitle", "Modification" );
			model.addAttribute( "user_id", user_id );
			
		}
		else {
			
			System.out.println( "null 입니다." );
			
			// 등록 처리(신규 회원)
			model.addAttribute( "memberDTO", new MemberDTO() );
			model.addAttribute( "formTitle", "Registration" );
			
		}

		return "member/memberWriteFormNew"; // memberWriteFormNew.html
	}

	
	/*
	 * 회원 등록 Ok
	 * 
	 */
	@PostMapping("/member/memberWriteOk")
	public String insertMember(@ModelAttribute("memberDTO") MemberDTO m1, Model model) {
	    try {
	        // 등록 처리
	        System.out.println(m1.getUser_name());
	        System.out.println(m1.getLog_id());
	        System.out.println(m1.getUser_gender());

	        	        
	        // MemberDTO에 조합한 이메일 주소 설정
	        String email = m1.getLog_id() + "@" + m1.getEmailDomain();
	        
	        // MemberDTO에 조합한 이메일 주소 설정
	        m1.setLog_id(email);
	        
	        memberService.insertMember(m1);

	        // 등록 안내 메시지 출력
	        model.addAttribute("msg", "회원 등록이 처리되었습니다. 메인 페이지로 이동합니다.");
	        model.addAttribute("url", "/");

	        return "member/messageAlert";  // messageAlert.html

	    } catch (Exception e) {
	        // 에러 처리
	    }

	    return "redirect:/";
	}
	
	
	@GetMapping("/checkDuplicateId")
    public ResponseEntity<String> checkDuplicateId(@RequestParam String logId) {
        if (memberService.isIdDuplicate(logId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 아이디입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 아이디입니다.");
        }
    }

    @GetMapping("/checkDuplicateNickname")
    public ResponseEntity<String> checkDuplicateNickname(@RequestParam String nickname) {
        if (memberService.isNicknameDuplicate(nickname)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 닉네임입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 닉네임입니다.");
        }
    }
	
	

	/*
	 * 회원 수정 Ok
	 * 
	 */
    @PostMapping("/member/memberUpdateOk")
    public String updateMember(
           @ModelAttribute MemberDTO m1,
           @RequestParam("user_id") int user_id,
           @RequestParam("log_id") String log_id,
           RedirectAttributes redirectAttributes,
           Model model) {

        try {
            // 수정 처리
            System.out.println(m1.getLog_id());
            System.out.println(m1.getLog_pw());
            System.out.println("넘어온 번호는 = " + user_id);
            
            // 이전 닉네임 가져오기
            MemberDTO previousname = memberService.getMemberOne(user_id);
            String previousNickname = previousname.getNickname();
            m1.setPreviousNickname(previousNickname);
            System.out.println("이전 닉네임 : "+ previousNickname);
            // 수정 후 닉네임 중복 체크
            boolean isNickname = memberService.isNickname(m1.getNickname());
            System.out.println(isNickname);
            if (isNickname && !previousNickname.equals(m1.getNickname())) {
                System.out.println("넘어가는곳 : 3");
                // 이미 사용 중인 닉네임이므로 사용자에게 알려줍니다.
                redirectAttributes.addFlashAttribute("msg", "이미 사용 중인 닉네임입니다. 다른 닉네임을 선택해주세요.");
                return "redirect:/mainpage/editinfo?log_id=" + log_id + "&user_id=" + user_id;  // 개인정보 수정 페이지로 다시 이동
            }
                
            if(m1.getImg_path() == null) {
                System.out.println("넘어가는곳 : 4");
               MemberDTO previousMember = memberService.getMemberOne(m1.getUser_id());
               m1.setImg_path(previousMember.getImg_path());
            }
            
            memberService.updateMember(m1);

            redirectAttributes.addFlashAttribute("msg", "회원 정보가 수정되었습니다. 확인 페이지로 이동합니다. ^.~");
            return "redirect:/mainpage/mainpage?log_id=" + log_id + "&user_id=" + user_id;

        } catch (Exception e) {
            // 예외 처리
        }

        return "redirect:/mainpage/mainpage?log_id=" + log_id + "&user_id=" + user_id;
    }
	
	
	/*
	 * 회원 리스트
	 * 
	 */
	@GetMapping("/member/memberList")
	public String memberList( Model model ) {
		
		List<MemberDTO> memberList = memberService.getMemberList();
		
		// 객체 리스트 전달 - 모델에 담아서 리스트 페이지로 전달
		model.addAttribute( "memberList", memberList );
		
		return "member/memberList";  // memberList.html
	}
	
	
	/*
	 * 회원 삭제 Ok (생각보다 생각할게 많네..ㅠ.ㅠ)
	 * 
	 */
	@GetMapping("/member/memberDeleteOk")
	public String memberDeleteOk( @RequestParam( value="user_id", required=false ) Integer user_id, Model model ) {
		
		// null 체크
		if( user_id == null ) {
			System.out.println( "null 입니다." );
			return "redirect:/member/memberList";
		}
		System.out.println( user_id );
		
		// try .. catch ~
		try {
			int isOk = memberService.deleteMember(user_id);
			System.out.println( "isOk = " + isOk );
			
			if( isOk != 1 ) {
				System.out.println( "삭제 실패 = " + isOk );
				
				model.addAttribute( "msg", "회원 삭제가 실패되었습니다. 리스트로 이동합니다." );
				model.addAttribute( "url", "/member/memberList" );
			}
			else {
				System.out.println( "삭제 성공 = " + isOk );
				
				model.addAttribute( "msg", "회원 정보가 삭제되었습니다. 멤버 리스트 페이지로 이동합니다. ^.~" );
				model.addAttribute( "url", "/member/memberList" );
			}			
		}
		catch( DataAccessException e ) {
			// DB 처리시 문제가 있나???
			
		}
		catch( Exception e ) {
			// 시스템에 문제가 있나???
			
		}
		
		return "member/messageAlert";  // messageAlert.html
	}
	
	
	
	@PostMapping("/member/memberFindId")
	@ResponseBody
	public ResponseEntity<String> memberFind(@RequestParam("user_name") String user_name,
	                         				@RequestParam("user_birth") String user_birth) {
		// 이름이랑 생년월일이 빈 값인지 확인
	    if (user_name.isEmpty() || user_birth.isEmpty()) {
	    	return ResponseEntity.ok("{\"errorMessage\": \"이름 또는 생년월일을 잘못 적으셨습니다.\"}");
	    }
	    System.out.println("user_name: " + user_name);
	    System.out.println("user_birth: " + user_birth);
	    
	    // 아이디 찾기
	    String foundId = memberService.authenticateAsLogid(user_name, user_birth);
	    System.out.println("foundId: " + foundId);
	    	
	    // 아이디가 존재하는 경우
	    if (foundId != null && !foundId.equals("errorMsg")) {
	        System.out.println("log_id: " + foundId);
	        return ResponseEntity.ok("{\"foundId\": \"" + foundId + "\"}");
	    } else { // 아이디가 존재하지 않는 경우
	    	return ResponseEntity.ok("{\"errorMessage\": \"이름 또는 생년월일을 잘못 적으셨습니다.\"}");
	    }
    }
	
	@PostMapping("/member/memberFindPw")
	@ResponseBody
	public ResponseEntity<String> memberFindPw(@RequestParam("log_id") String log_id,    
	                                           @RequestParam("user_name") String user_name,
	                                           @RequestParam("user_birth") String user_birth) {
	    // 아이디와 이름이랑 생년월일이 빈 값인지 확인
	    if (log_id.isEmpty() || user_name.isEmpty() || user_birth.isEmpty()) {
	        return ResponseEntity.ok("{\"errorMessage\": \"입력된 정보가 부족합니다.\"}");
	    }
	    System.out.println("log_id: " + log_id);
	    System.out.println("user_name: " + user_name);
	    System.out.println("user_birth: " + user_birth);
	    
	    // 비밀번호 찾기
	    String foundPw = memberService.authenticateAsLogPw(log_id, user_name, user_birth);
	    System.out.println("foundId: " + foundPw);
	    	
	    // 아이디가 존재하는 경우
	    if (foundPw != null && !foundPw.isEmpty()) {
	        return ResponseEntity.ok("{\"foundPw\": \"" + foundPw + "\"}");
	    } else { // 아이디가 존재하지 않는 경우
	        return ResponseEntity.ok("{\"errorMessagePw\": \"비밀번호를 찾을 수 없습니다.\"}");
	    }
	}
}