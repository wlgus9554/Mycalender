package com.mycalender.util.interceptor;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.mycalender.member.vo.LoginVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class AuthrityInterceptor extends HandlerInterceptorAdapter {

    // 권한 정보 (페이지 URI -> 권한)
    private Map<String, String> authMap = new HashMap<>();

    // 초기화 블록 - 권한 설정
    {
        // "user" 등급이면 접근 가능
        authMap.put("/boardreply/write.do", "user"); 
        authMap.put("/member/logout.do", "user");

        // "admin" 등급만 접근 가능
        authMap.put("/goods/writeForm.do", "admin");
        authMap.put("/goods/write.do", "admin");
        authMap.put("/goods/updateForm.do", "admin");
        authMap.put("/goods/update.do", "admin");
        authMap.put("/goods/delete.do", "admin");
        authMap.put("/goods/changeImage.do", "admin");
        authMap.put("/goods/addSize.do", "admin");
        authMap.put("/goods/addColor.do", "admin");
        authMap.put("/goods/changePrice.do", "admin");
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler)
        throws Exception {

        log.info("🚀 권한 처리 Interceptor 실행...");

        // 요청한 페이지 URI 확인
        String uri = request.getRequestURI();
        String pageGrade = authMap.get(uri);

        // 권한이 필요한 페이지인 경우
        if (pageGrade != null) {
            HttpSession session = request.getSession();
            LoginVO vo = (LoginVO) session.getAttribute("login");

            // 로그인 안 한 경우 → 로그인 오류 페이지로 이동
            if (vo == null) {
                request.getRequestDispatcher("/WEB-INF/views/error/loginError.jsp")
                        .forward(request, response);
                return false;
            }

            // 사용자 등급 확인
            String userGrade = vo.getGrade();
            log.info("✅ 사용자 등급: " + userGrade);
            log.info("✅ 페이지 필요 등급: " + pageGrade);

            // 권한 비교 (admin만 접근 가능해야 하는 페이지)
            if ("admin".equals(pageGrade) && !"admin".equals(userGrade)) {
                request.getRequestDispatcher("/WEB-INF/views/error/authError.jsp")
                        .forward(request, response);
                return false;
            }
        }

        // 권한이 충분하면 요청 계속 진행
        return super.preHandle(request, response, handler);
    } 
}
