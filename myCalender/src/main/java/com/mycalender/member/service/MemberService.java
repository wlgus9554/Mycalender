package com.mycalender.member.service;

import com.mycalender.member.vo.LoginVO;

public interface MemberService {

	// 로그인
	public LoginVO login(LoginVO vo);
}
