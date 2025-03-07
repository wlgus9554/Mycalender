package com.mycalender.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycalender.member.service.MemberService;
import com.mycalender.member.vo.LoginVO;
import com.mycalender.member.vo.MemberVO;
import com.mycalender.util.file.FileUtil;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {

	// 파일 저장 경로
	String path = "/upload/member";
	
	// 자동 DI
	// @Setter(onMethod_ = @Autowired)
	// Type이 같으면 식별할 수 있는 문자열 지정 - id 지정
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService service;
	
	//--- 회원가입 폼 ------------------------------------
		@GetMapping("/joinForm.do")
		public String writeForm() {
			log.info("joinForm.do");
			return "member/joinForm";
		}
		
		//--- 회원가입 처리 ------------------------------------
		@PostMapping("/join.do")
		public String write(MemberVO vo, RedirectAttributes rttr, HttpServletRequest request,
				MultipartFile imageFile) throws Exception {
			log.info("----------[ join.do ] -----------");
			
			// 회원 이미지
			vo.setImage(FileUtil.upload(path, imageFile, request));
			
			log.info("설정된 gradeNo : " + vo.getGrade());
			
			log.info("회원 이미지 : " + imageFile.getOriginalFilename());
			log.info("join vo ------------------------" + vo);
			vo.setGrade("user"); // 기본 셋팅값은 user로 강제 설정
			service.join(vo);
			
			// 처리 결과에 대한 메시지 처리
			rttr.addFlashAttribute("msg", vo.getNickName() +"님 My Calender 회원이 되신걸 환영합니다!");
			
			return "redirect:/main/main.do";
		}
	
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
	
	// 로그아웃
	@GetMapping("/logout.do")
	public String logout( HttpSession session, 
			RedirectAttributes rttr) {
		log.info("logout..................");
		
		session.removeAttribute("login");
		
		rttr.addFlashAttribute("msg", "로그아웃 되었습니다.");
		
		return "redirect:/main/main.do";
	}

}
