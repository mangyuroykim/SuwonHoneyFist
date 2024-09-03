package com.SuwonHoneyFist.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SuwonHoneyFist.notice.model.vo.Notice;

public class NoticeDAO {

	public List<Notice> selectList(Connection conn, int currentPage) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Notice> nList = null;
		//currentPage : 1, start : 1, end : 10
		//currentPage : 2, start : 11, end : 20
		//currentPage : 3, start : 21, end : 30
//		int currentPage = 1;
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NOTICE_NO DESC) RNUM, N.* FROM NOTICE_TBL N) WHERE RNUM BETWEEN ? AND ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rset = pstmt.executeQuery();
		nList = new ArrayList<Notice>();
		while(rset.next()) {
			Notice notice = new Notice();
			notice.setNoticeNo(rset.getInt("NOTICE_NO"));
			notice.setNoticeSubject(rset.getString("NOTICE_SUBJECT"));
			notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
			notice.setNoticeWriter(rset.getString("NOTICE_WRITER"));
			notice.setRegDate(rset.getTimestamp("REG_DATE"));
			notice.setUpdateDate(rset.getTimestamp("UPDATE_DATE"));
			notice.setViewCount(rset.getInt("VIEW_COUNT"));
			nList.add(notice);
		}
		pstmt.close();
		rset.close();
		return nList;
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "SELECT COUNT(*) TOTAL_COUNT FROM NOTICE_TBL";
		pstmt = conn.prepareStatement(query);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			// rsetToint
			totalCount = rset.getInt("TOTAL_COUNT");
		}
		pstmt.close();
		rset.close();
		return totalCount;
	}



}
