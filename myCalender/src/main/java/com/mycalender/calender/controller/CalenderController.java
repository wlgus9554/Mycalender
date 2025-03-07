package com.mycalender.calender.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycalender.util.aop.LoginRequired;

@RestController
@RequestMapping("/calender")
public class CalenderController {

    @LoginRequired
    @GetMapping(produces = "text/html; charset=UTF-8")  // UTF-8 강제 설정
    public String getCalender() {
        return "캘린더 데이터 반환";  // 한글 정상 표시 확인
    }
    
}
