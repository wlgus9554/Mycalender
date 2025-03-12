package com.mycalendar.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycalendar.member.mapper.MemberMapper;
import com.mycalendar.member.vo.LoginVO;
import com.mycalendar.member.vo.MemberVO;
import com.mycalendar.util.page.PageObject;

import lombok.extern.log4j.Log4j;

@Service("memberServiceImpl")
@Log4j
@Qualifier("memberServiceImpl")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	// 로그인
	@Override
	public LoginVO login(LoginVO vo) {
		// TODO Auto-generated method stub
		log.info(vo);
		return mapper.login(vo);
	}

	// 회원가입
	@Override
	public Integer join(MemberVO vo) {
		// TODO Auto-generated method stub
		log.info(vo);
		return mapper.join(vo);
	}

	@Override
	public List<MemberVO> memberList(PageObject pageObject) {
		// TODO Auto-generated method stub
		log.info("getMemberList..........." + mapper.memberList(pageObject));
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.memberList(pageObject);
	}

	@Override
	public Long getTotalRow(PageObject pageObject) {
		// TODO Auto-generated method stub
		return mapper.getTotalRow(pageObject);
	}

	@Override
	public MemberVO view(String email) {
		// TODO Auto-generated method stub
		log.info("member view......................" + mapper.view(email));
		return mapper.view(email);
	}


}
