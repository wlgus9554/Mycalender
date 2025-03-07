package com.mycalender.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mycalender.member.vo.LoginVO;
import com.mycalender.member.vo.MemberVO;

@Repository
@Mapper
public interface MemberMapper {
	
	// 로그인
	public LoginVO login(LoginVO vo);
	
	// 회원가입
	public Integer join(MemberVO vo);

}
