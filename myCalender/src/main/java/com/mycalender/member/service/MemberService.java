package com.mycalender.member.service;

import com.mycalender.member.vo.LoginVO;
import com.mycalender.member.vo.MemberVO;

public interface MemberService {

	// 로그인
	public LoginVO login(LoginVO vo);
	
	// 회원가입
	public Integer join(MemberVO vo);
}
