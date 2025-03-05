package com.mycalender.member.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycalender.member.mapper.MemberMapper;
import com.mycalender.member.vo.LoginVO;

import lombok.extern.log4j.Log4j;

@Service("memberServiceImpl")
@Log4j
@Qualifier("memberServiceImpl")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public LoginVO login(LoginVO vo) {
		// TODO Auto-generated method stub
		log.info(vo);
		return mapper.login(vo);
	}

}
