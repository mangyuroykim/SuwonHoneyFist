package com.SuwonHoneyFist.notice.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SuwonHoneyFist.common.JDBCTemplate;
import com.SuwonHoneyFist.notice.model.dao.NoticeDAO;
import com.SuwonHoneyFist.notice.model.vo.Notice;

public class NoticeService {

	private NoticeDAO nDao;
	
	public NoticeService() {
		nDao = new NoticeDAO();
	}
	
	public List<Notice> selectNoticeList(int currentPage) {
		Connection conn = null;
//		List<Notice> nList = null;
		List<Notice> nList = new ArrayList<Notice>();
		try {
			conn = JDBCTemplate.getConnection();
			nList = nDao.selectList(conn, currentPage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nList;
	}

	public int getTotalCount(){
		Connection conn = null;
		int totalCount = 0;
		try {
			conn = JDBCTemplate.getConnection();
			totalCount = nDao.selectTotalCount(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totalCount;
	}

}
