package com.benq.spring.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter", urlPatterns= {"/board/*", "/member/mypage.kh", "/notice/register.kh","/reply/insert.kh"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // 서버가 동작하면 필터 코드가 변경되었을 때 필터가 생성됨.
        System.out.println("--- 로그인 필터 생성 ---");
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // 필터 코드가 변경되면 이전 필터를 파괴하는 메소드
        System.out.println("--- 이전 로그인 필터 파괴---");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // HttpServletRequest, HttpServletResponse으로 다운캐스팅
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 세션 얻어오기
        HttpSession session = req.getSession();

        // 로그인 여부 확인
        String memberId = (String) session.getAttribute("memberId");
        if (memberId != null) {
            // 로그인 한 경우 다음 필터 또는 DispatcherServlet으로 전달
            chain.doFilter(request, response);
        } else {
            // 로그인되지 않은 경우 경고 메시지를 표시하고 홈 페이지로 리다이렉트
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<script>alert('로그인 정보가 존재하지 않습니다.');location.href='/';</script>");
            writer.flush();  // writer를 닫기 전에 flush하여 모든 데이터를 출력
        }
    }
}
