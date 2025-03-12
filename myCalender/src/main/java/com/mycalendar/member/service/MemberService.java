package com.mycalendar.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycalendar.member.vo.LoginVO;
import com.mycalendar.member.vo.MemberVO;
import com.mycalendar.util.page.PageObject;

public interface MemberService {

	// 로그인
	public LoginVO login(LoginVO vo);
	
	// 회원가입
	public Integer join(MemberVO vo);

	// 회원리스트
	public List<MemberVO> memberList(PageObject pageobject);
	
	// 전체 회원 조회
	public Long getTotalRow(PageObject pageObject);
	
	// 선택한 회원의 정보 상세보기
	public MemberVO view(@Param("email") String email);
}
