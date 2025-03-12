package com.mycalendar.util.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j  // 로그 사용
public class LoginAspect {

    private final HttpSession session;

    public LoginAspect(HttpSession session) {
        this.session = session;
    }

    @Before("@annotation(com.mycalendar.util.aop.LoginRequired)")
    public void checkLogin(JoinPoint joinPoint) throws Throwable {
        Object user = session.getAttribute("login"); // 세션에서 로그인 정보 확인

        log.info("🔍 [AOP] 세션에서 가져온 user 값: {}", user); // 디버깅 로그 추가

        if (user == null) {
            log.error("🚫 [AOP] 로그인되지 않은 사용자 접근 차단!");
            throw new RuntimeException("로그인이 필요합니다.");
        }

        log.info("✅ [AOP] 로그인 확인 완료 - user: {}", user);
    }
}
