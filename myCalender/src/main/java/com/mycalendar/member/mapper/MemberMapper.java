package com.mycalendar.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mycalendar.member.vo.LoginVO;
import com.mycalendar.member.vo.MemberVO;
import com.mycalendar.util.page.PageObject;

@Repository
@Mapper
public interface MemberMapper {
	
	// 로그인
	public LoginVO login(LoginVO vo);
	
	// 회원가입
	public Integer join(MemberVO vo);
	
	// 회원리스트
	public List<MemberVO> memberList(PageObject pageObject);
	
	// 전체 회원 조회
	public Long getTotalRow(PageObject pageObject);
	
	// 선택한 회원의 정보 상세보기
	public MemberVO view(@Param("email") String email);

}
