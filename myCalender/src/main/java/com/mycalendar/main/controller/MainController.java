package com.mycalendar.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainController {

	@GetMapping(value = {"/", "/main.do"})
	public String goMain() {
		log.info("로그인 폼 이동........");
		return "redirect:/main/main.do";
	}
	
	@GetMapping(value = {"/main/main.do"})
	public String main(Model model) {
		log.info("/member/main.do  .........");
		return "main/main";
	}
	
}
