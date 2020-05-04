package com.example.cuni.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@RequestMapping("/member/doLogin")
	@ResponseBody
	public String doLogin(HttpSession session, String loginId, String loginPw) {
		if (loginId.equals("user1") && loginPw.equals("1234")) {
			session.setAttribute("isLogined", "OK");
			
			return "로그인되었습니다.";
		} else {
			return "올바르지 않은 계정 정보";
		}
	}
	
	@RequestMapping("/member/checkLogined")
	@ResponseBody
	public String checkLogined(HttpSession session) {
		String isLogined = (String) session.getAttribute("isLogined");
		
		if (isLogined == null) {
			return "미로그인";
		} else if (isLogined.equals("OK")) {
			return "로그인";
		}
		
		return "";
	}
	
	@RequestMapping("/member/test1")
	@ResponseBody
	public String test1() {
		return "123";
	}
}
