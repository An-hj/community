package com.example.cuni.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.cuni.dto.Member;

@Mapper
public interface MemberDao {

	Member getMemberByLoginId(String loginId);

	void join(Map<String, Object> param);

}
