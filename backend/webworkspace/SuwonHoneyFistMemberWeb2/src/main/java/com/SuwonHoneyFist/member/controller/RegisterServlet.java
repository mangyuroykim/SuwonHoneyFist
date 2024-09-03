package com.SuwonHoneyFist.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SuwonHoneyFist.member.model.service.MemberService;
import com.SuwonHoneyFist.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/join.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String memberID 	= request.getParameter("member-id");
		String memberPW 	= request.getParameter("member-pw");
		String memberNAME 	= request.getParameter("member-name");
		String memberGENDER = request.getParameter("gender");
		String age 			= request.getParameter("age");
		String email 		= request.getParameter("email");
		String phone 		= request.getParameter("phone");
		String address 		= request.getParameter("address");
		String hobby 		= request.getParameter("hobby");
		
		Member member = new Member(memberID, memberPW, memberNAME, memberGENDER, Integer.parseInt(age), email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		
		System.out.println(result);
		
		if( result > 0 ) {
			
			//	성공 메세지 출력
			//	1. redirect
			//	respones.sendRedirect("");
			//	2. requestDispatcher
			//	request.setAttribute("msg","성공");
			//	request.getRequstDispatcher("").forward(request, request);
			
			response.sendRedirect("/index.jsp");
			
		}else {
			
			response.sendRedirect("/common/error/errorPage.jsp");
		
		}
	}

}
