package com.mycalender.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycalender.member.service.MemberService;
import com.mycalender.member.vo.LoginVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {

	// 자동 DI
	// @Setter(onMethod_ = @Autowired)
	// Type이 같으면 식별할 수 있는 문자열 지정 - id 지정
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService service;
	
	// 로그인 폼
	@GetMapping("/loginForm.do")
	public String loginForm() {
		log.info("loginForm.do");
		return "member/loginForm";
	}
	
	// 로그인 폼
	@PostMapping("/login.do")
	public String login(LoginVO vo, HttpSession session, RedirectAttributes rttr) {
		log.info("login.do");
		
		LoginVO loginVO = service.login(vo);
		
		if(loginVO == null) {
			rttr.addFlashAttribute("msg", "로그인 정보가 맞지 않습니다. 다시 입력해주세요.");
			return "redirect:/member/loginForm.do";
		}
		
		session.setAttribute("login", loginVO);
		rttr.addFlashAttribute("msg", loginVO.getNickName() + "님이 접속하였습니다.");
		
		return "redirect:/main/main.do";
	}

}
