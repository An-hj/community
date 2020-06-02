package com.example.cuni.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.cuni.dto.Member;
import com.example.cuni.service.MemberService;

@Component("beforeActionInterceptor")
public class BeforeActionInterceptor implements HandlerInterceptor {

	@Autowired
	private MemberService memberService;
	
	@Value("${custom.logoText}")
	String logoText;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception {
		request.setAttribute("logoText", logoText);
		HttpSession session = request.getSession();
		
		Integer loginedMemberId = (Integer) session.getAttribute("loginedMemberId");
		
		if (loginedMemberId == null) {
			loginedMemberId = 0;
		} else {
			Member member = memberService.getMemberById(loginedMemberId);
			
			request.setAttribute("loginedMember", member);
		}
		
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("isLogined", loginedMemberId != 0);
		request.setAttribute("name", "홍길동");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
