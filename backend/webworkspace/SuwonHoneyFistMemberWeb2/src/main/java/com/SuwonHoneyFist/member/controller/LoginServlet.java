package com.SuwonHoneyFist.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SuwonHoneyFist.member.model.service.MemberService;
import com.SuwonHoneyFist.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String memberID = request.getParameter("memberID");
			String memberPW = request.getParameter("memberPW");
			Member member = new Member(memberID, memberPW);
			MemberService mService = new MemberService();
			member = mService.checkLogin(member);
			if (member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("memberID", member.getMemberID());
				session.setAttribute("memberName", member.getMemberNAME());
				response.sendRedirect("/");
			} else {
				request.setAttribute("msg", "존재하지 않는 정보입니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);

		}
	}
}
