package com.benq.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.benq.notice.model.service.NoticeService;
import com.benq.notice.model.vo.Notice;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/notice/list.kh")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public ListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NoticeService nService = new NoticeService();
        // 쿼리 스트링이 누락됐다고 하더라도 첫번째 페이지를 보여줄 수 있도록 기본값 1로 셋팅을 하는 삼항 연산자
        int currentPage = request.getParameter("currentPage") != null ? Integer.parseInt(request.getParameter("currentPage")) : 1;
        List<Notice> nList = nService.selectAllNotice(currentPage);
        // SELECT * FROM NOTICE_TBL
//      if(nList != null) {
//      if(!nList.isEmpty()) {
        int totalCount = 314;
        int recordCountPerPage = 10;
        int naviTotalCount = 0;
        if(totalCount % recordCountPerPage > 0) {
        	naviTotalCount = totalCount / recordCountPerPage + 1;
        } else {
        	naviTotalCount = totalCount / recordCountPerPage;
        }
        int naviCountPerPage = 10;
        // currentPage 1~10, startNavi : 1, endNavi : 10
        // currentPage 11~20, startNavi : 11, endNavi : 20
        // currentPage 21~30, startNavi : 21, endNavi : 30
        int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;
        int endNavi = startNavi + naviCountPerPage - 1;
        if(endNavi > naviTotalCount) {
            endNavi = naviTotalCount;
        }
        if(nList.size() > 0) {
            // list.jsp로 이동
            request.setAttribute("startNavi", startNavi);
            request.setAttribute("endNavi", endNavi);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("naviTotalCount", naviTotalCount);
            request.setAttribute("nList", nList);
            request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "존재하지 않는 정보입니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }
}
