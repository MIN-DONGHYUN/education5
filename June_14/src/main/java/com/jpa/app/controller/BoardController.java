package com.jpa.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.app.domain.Board;
import com.jpa.app.domain.Member;
import com.jpa.app.service.InterBoardService;

@Controller
@RequestMapping(value="/board/*") 
public class BoardController {

	@Autowired
	private InterBoardService boardService;
	
	@RequestMapping(value="list")
	public String list(@RequestParam(defaultValue = "") String searchType,
			           @RequestParam(defaultValue = "") String searchWord,
			           Model model) {

		try {
			List<Board> board_List = boardService.listBoard(searchType, searchWord);  
			model.addAttribute("board_List", board_List);
			
			if(!"".equals(searchType) && !"".equals(searchWord)) {
				model.addAttribute("searchType", searchType); // view단페이지에서 검색타입 유지
				model.addAttribute("searchWord", searchWord); // view단페이지에서 검색어 유지
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "board/list";
	}
	
	@GetMapping("write")
	public String writeForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member loginuser = (Member) session.getAttribute("loginuser");
		
		if(loginuser == null) {
			String message = "게시글을 쓰려면 먼저 로그인 하셔야 합니다.";
		 	String loc = request.getContextPath()+"/member/login";
		 	   	   
		 	request.setAttribute("message", message);
		 	request.setAttribute("loc", loc);
		 	return "msg";
		}
		
		return "board/write";
	}
	
	
	@PostMapping("write")
	public String writeSubmit(Board dto) {
        
		System.out.println("userId : " + dto.getFk_userId());
		System.out.println("글제목 : " + dto.getSubject());
		System.out.println("글내용 : " + dto.getContent());
		
		try {
			boardService.insertBoard(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}
	
	
	@GetMapping("view")
	public String view(@RequestParam long num, HttpServletRequest request) {

		try {
			Board dto = boardService.viewBoard(num);
			
			if (dto == null) {
				String message = "해당 게시글이 존재하지 않습니다.";
			 	String loc = request.getContextPath()+"/board/list";
			 	   	   
			 	request.setAttribute("message", message);
			 	request.setAttribute("loc", loc);
			 	return "msg";
			}
	
			else {
				HttpSession session = request.getSession();
				Member loginuser = (Member) session.getAttribute("loginuser");
				
				// 로그인해서 다른 사용자가 작성한 글을 조회할 경우 
				if( loginuser != null &&
					!loginuser.getUserId().equals(dto.getFk_userId()) ) {
					boardService.updateReadCount(num); // 조회수 증가하기
				}
				
				dto = boardService.viewBoard(num); // 조회수 증가한 경우 또는 조회수 증가하지 않은 경우 가져오기 
				
				request.setAttribute("dto", dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "board/view";
	}
	
	
	@GetMapping("update")
	public String updateForm(@RequestParam long num, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Member loginuser = (Member) session.getAttribute("loginuser");
		
		if(loginuser == null) {
			String message = "게시글을 수정하시려면 먼저 로그인 하셔야 합니다.";
		 	String loc = request.getContextPath()+"/member/login";
		 	   	   
		 	request.setAttribute("message", message);
		 	request.setAttribute("loc", loc);
		 	return "msg";
		}
		
		else {
			try {
				Board dto = boardService.viewBoard(num);
				if (dto == null) { // 게시글이 없을 경우
					return "redirect:/board/list";
				}
				else if(dto != null && !dto.getFk_userId().equals(loginuser.getUserId())) { // 다른 사람의 게시글인 경우
					String message = "다른 사용자의 글은 수정이 불가합니다.";
				 	String loc = request.getContextPath()+"/board/list";
				 	   	   
				 	request.setAttribute("message", message);
				 	request.setAttribute("loc", loc);
				 	return "msg";
				}
				else {
					request.setAttribute("dto", dto);
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return "board/update";
		}
	}

	
	@PostMapping("update")
	public String updateSubmit(Board dto) {
		try {
			boardService.updateBoard(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/board/list";
	}

	
	@GetMapping("delete")
	public String delete(@RequestParam long num, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member loginuser = (Member) session.getAttribute("loginuser");
		
		if(loginuser == null) {
			String message = "게시글을 삭제하시려면 먼저 로그인 하셔야 합니다.";
		 	String loc = request.getContextPath()+"/member/login";
		 	   	   
		 	request.setAttribute("message", message);
		 	request.setAttribute("loc", loc);
		 	return "msg";
		}
		
		else {
			try {
				Board dto = boardService.viewBoard(num);
				if (dto == null) { // 게시글이 없을 경우
					return "redirect:/board/list";
				}
				else if(dto != null && !dto.getFk_userId().equals(loginuser.getUserId())) { // 다른 사람의 게시글인 경우
					String message = "다른 사용자의 글은 삭제가 불가합니다.";
				 	String loc = request.getContextPath()+"/board/list";
				 	   	   
				 	request.setAttribute("message", message);
				 	request.setAttribute("loc", loc);
				 	return "msg";
				}
				else {
					boardService.deleteBoard(num);
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/board/list";
		}
	}
	
}
