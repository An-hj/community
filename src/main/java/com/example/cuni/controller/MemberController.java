package com.example.cuni.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cuni.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping("member/join")
	String showJoin() {
		return "member/join";
	}
	
	@RequestMapping("member/doJoin")
	public String doJoin(Model model, @RequestParam Map<String, Object> param) {
		Map<String, Object> rs = memberService.join(param);
		
		String resultCode = (String) rs.get("resultCode");
		
		if (resultCode.startsWith("S-")) {
			String redirectUrl = "/member/login";
			model.addAttribute("jsAlertMsg", rs.get("msg"));
			model.addAttribute("jsLocationReplaceUrl", redirectUrl);
		} else {
			model.addAttribute("jsAlertMsg", rs.get("msg"));
			model.addAttribute("jsLocationReplaceUrl", true);
		}
		
		return "redirect";
	}
	
}
