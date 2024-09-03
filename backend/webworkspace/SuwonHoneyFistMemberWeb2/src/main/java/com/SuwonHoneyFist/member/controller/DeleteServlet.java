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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/remove.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	회원탈퇴 -> 쿼리문? 
		//	-> DELETE FROM MEMBER_TBL WHERE MEMBER_ID = '로그인한 ID';
		String memberID = request.getParameter("memberID");
		MemberService mService = new MemberService();
		int result = mService.deleteMember(memberID);
		if(result > 0 ) {
			//	로그아웃 후 메인으로 이동
			//	1. 세션을 가져온 후
			//	2. 세션을 파괴하고
			//	3. 메인 페이지로로 이동
			response.sendRedirect("/member/logout.do");
		}else {
			
			request.setAttribute("msg", "탈퇴 실패");
			RequestDispatcher view
			= request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
			view.forward(request, response);
		}
	
	
	}

}
