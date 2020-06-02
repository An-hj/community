package com.example.cuni.service;

import java.util.Map;

import com.example.cuni.dto.Member;

public interface MemberService {

	Map<String, Object> join(Map<String, Object> param);

	Map<String, Object> checkLoginAvailable(Map<String, Object> param);

	Member getMemberById(int id);

}
