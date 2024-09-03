package com.SuwonHoneyFist.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SuwonHoneyFist.notice.model.service.NoticeService;
import com.SuwonHoneyFist.notice.model.vo.Notice;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/notice/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// SELECT * FROM NOTICE_TBL
		// SELECT * FROM (SELECT ROW_NUMBER OVER(ORDER BY NOTICE_NO DESC) RNUM, N.* FROM NOTICE_TBL) WHERE RNUM BETWEEN 1 AND 10;
//
//
		try {
			int currentPage = (request.getParameter("currentPage") != null) ? Integer.parseInt(request.getParameter("currentPage")) : 1;
			NoticeService nService = new NoticeService();
			List<Notice> nList = nService.selectNoticeList(currentPage);
			// currentPage : 1~10, startNavi : 1, endNavi : 10;
			// currentPage : 11~20, startNavi : 11, endNavi : 20;
			// currentPage : 21~30, startNavi : 21, endNavi : 30;
			// 한 페이지당 보여주는 navi의 수와 currentPage를 활용해야함
			int totalCount = nService.getTotalCount();
			int recordCountPerPage = 10;
			int naviTotalCount = 0;
			if(totalCount % recordCountPerPage > 0) {
				naviTotalCount = totalCount/recordCountPerPage + 1;
			}else {
				naviTotalCount = totalCount/recordCountPerPage;
			}

			int naviCountPerPage = 10;
			int startNavi = ((currentPage -1)/naviCountPerPage)*naviCountPerPage +1;//조건에 따라 변할 수 있는 식을 만들어야함!
			int endNavi = startNavi + naviCountPerPage -1;
			if(endNavi > naviTotalCount) {
				endNavi = naviTotalCount;
			}
//			if(nList != null) {
			if(!nList.isEmpty()) {
				request.setAttribute("startNavi", startNavi);
				request.setAttribute("endNavi", endNavi);
				request.setAttribute("nList", nList);
				request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "정보가 존재하지 않습니다.");
				RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
			view.forward(request, response);
		}
	}													

}
