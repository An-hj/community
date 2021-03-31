package com.example.cuni.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.cuni.dto.Member;

@Mapper
public interface MemberDao {

	void join(Map<String, Object> param);

	Member getMemberByLoginId(@Param("loginId") String loginId);

	Member getMemberById(@Param("id") int id);

}