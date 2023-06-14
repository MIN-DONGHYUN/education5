package com.jpa.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.app.domain.Member;
import com.jpa.app.service.InterMemberService;

@Controller
@RequestMapping(value="/member/*") 
public class MemberController {

	@Autowired
	private InterMemberService memberService;
	
	@GetMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	@PostMapping("loginEnd")
	public String loginEnd(@RequestParam String userId,   // form 태그의 name 속성값과 같은것이 매핑되어짐
			               @RequestParam String userPwd,  // form 태그의 name 속성값과 같은것이 매핑되어짐
			               HttpServletRequest request) {
		
		Member mvo = memberService.getMember(userId);
		
		if(mvo == null || !userPwd.equals(mvo.getUserPwd())) {
			String message = "로그인 실패!!";
		 	String loc = request.getContextPath()+"/board/list";
		 	   	   
		 	request.setAttribute("message", message);
		 	request.setAttribute("loc", loc);
		 	return "msg";
		}
		
		// 세션에 로그인 사용자 정보 저장
		HttpSession session = request.getSession();
		session.setAttribute("loginuser", mvo);
		return "redirect:/board/list";
	}
	
	
	@GetMapping("logout")
	public String loginout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		String message = "로그아웃 되었습니다.";
	 	String loc = request.getContextPath()+"/board/list";
	 	   	   
	 	request.setAttribute("message", message);
	 	request.setAttribute("loc", loc);
	 	return "msg";
	}
	
}
