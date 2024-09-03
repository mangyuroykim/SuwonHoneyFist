package com.SuwonHoneyFist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SuwonHoneyFist.member.model.service.MemberService;
import com.SuwonHoneyFist.member.model.vo.Member;

@WebServlet("/member/login.kh")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String memberId = request.getParameter("memberId");
            String memberPw = request.getParameter("memberPw");
            Member member = new Member(memberId, memberPw);
            MemberService mService = new MemberService();
            member = mService.checkLogin(member);
            if(member != null) {
                HttpSession session = request.getSession();
                session.setAttribute("memberId", member.getMemberID());
                session.setAttribute("memberName", member.getMemberNAME());
                response.sendRedirect("/index.jsp");  // 로그인 후 메인 페이지로 리디렉션
            } else {
                request.setAttribute("msg", "로그인이 실패하였습니다."); // 로그인 실패 시 메시지
                request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }
}
