package com.jpa.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.app.domain.Guestbook;
import com.jpa.app.service.InterGuestService;

@Controller
@RequestMapping(value="/guest/*") 
public class GuestController {

	@Autowired
	private InterGuestService guestService;

	
	@RequestMapping(value="")
	public String start() {
		return "redirect:list";
	}
	
	
	@RequestMapping(value="list")
	public String list(Model model) {

		try {
			List<Guestbook> list = guestService.listGuest();
			model.addAttribute("list", list);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "guest/list";
	}
	
	
	@RequestMapping(value="write", method= {RequestMethod.GET})
	public String writeForm() {
		return "guest/write";
	}

	
	@RequestMapping(value="write", method= {RequestMethod.POST})
	public String writeSubmit(Guestbook dto) {

		try {
			guestService.insertGuest(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

	
	@RequestMapping(value="view", method= {RequestMethod.GET})
	public String view(HttpServletRequest request) {

		try {
			String num = request.getParameter("num");
			Guestbook dto = guestService.viewGuest(Long.parseLong(num));
			
			if (dto == null) {
				String message = "해당 방명록글이 존재하지 않습니다.";
			 	String loc = request.getContextPath()+"/guest/list";
			 	   	   
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
		
		return "guest/view";
	}

	
	@GetMapping("update")
	public String updateForm(@RequestParam long num, Model model) {

		try {
			Guestbook dto = guestService.viewGuest(num);
			if (dto == null) {
				return "redirect:/guest/list";
			}
	
			model.addAttribute("dto", dto);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "guest/update";
	}

	// @RequestMapping(value="update", method= {RequestMethod.GET}) 와 같은말 
	@PostMapping("update")
	public String updateSubmit(Guestbook dto) {
		try {
			guestService.updateGuest(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/guest/list";
	}

	
	@GetMapping("delete")
	public String delete(@RequestParam long num) {
		try {
			guestService.deleteGuest(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/guest/list";
	}
	
}

