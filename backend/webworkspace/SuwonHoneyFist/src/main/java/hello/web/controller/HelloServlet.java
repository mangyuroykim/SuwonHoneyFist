package hello.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = request.getParameter("member-id");
    	String memberPw = request.getParameter("member-pw");
    	System.out.println("아이디 : " + memberId + ", 비밀번호 : " + memberPw);
        
    	response.sendRedirect("/common/success.html");
    	System.out.println("동작완료");
    }
}