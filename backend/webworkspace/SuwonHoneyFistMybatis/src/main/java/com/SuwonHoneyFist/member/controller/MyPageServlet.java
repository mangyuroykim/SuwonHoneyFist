package com.SuwonHoneyFist.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SuwonHoneyFist.member.model.service.MemberService;
import com.SuwonHoneyFist.member.model.vo.Member;



/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/member/mypage.kh")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
//			String memberID = request.getParameter("memberID");
			//	SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?
			// 세션에서 아이디 가져오가 -> 로그인한 사용자에 한해서 마이페이지 정보를 가져올 수 있음.
			HttpSession session = request.getSession();			

			if(session != null) {
				String memberID = (String)session.getAttribute("memberID");
				MemberService mService = new MemberService();
				Member member = mService.selectOneById(memberID);
				if(member != null ) {
					request.setAttribute("member", member);
					request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp")
					.forward(request, response);
				}else {
					request.setAttribute("msg", "존재하지 않는 정보입니다.");
					request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
				}
				
			}else {
				request.setAttribute("msg", "로그인이 필요합니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp")
			.forward(request, response);
		}
	}

}