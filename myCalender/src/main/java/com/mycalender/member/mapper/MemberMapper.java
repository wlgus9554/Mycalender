package com.mycalender.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mycalender.member.vo.LoginVO;

@Repository
@Mapper
public interface MemberMapper {
	
	// 로그인
	public LoginVO login(LoginVO vo);

}
