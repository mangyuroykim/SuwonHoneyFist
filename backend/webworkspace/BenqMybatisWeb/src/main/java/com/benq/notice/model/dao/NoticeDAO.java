package com.benq.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.benq.notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public List<Notice> selectList(SqlSession session, int currentPage) {
		// 전달받은 값을 쓰기 위해서는 매개변수로 작성해줘야 함.
		// 메소드 밑에 사용할 변수로 적는 것이 아니라 메소드의 매개변수로 적어줘야함.
//		int currentPage = 1;
		// currentPage : 1, offset : 0
		// currentPage : 2, offset : 10
		// currentPage : 3, offset : 20
		// currentPage : 4, offset : 30
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectList", null, rowBounds);
		return nList;
	}

	public Notice selectOne(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOne", noticeNo);
		return notice;
	}

	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}
	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}
}







