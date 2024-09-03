package com.benq.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.benq.common.SqlSessionTemplate;
import com.benq.notice.model.dao.NoticeDAO;
import com.benq.notice.model.vo.Notice;

public class NoticeService {
	
	private SqlSession session;
	private NoticeDAO nDao;
	
	public NoticeService() {
		session = SqlSessionTemplate.getSqlSession();
		nDao = new NoticeDAO();
	}

	public int insertNotice(Notice notice) {
		int result = nDao.insertNotice(session, notice);
		return result;
	}

	public List<Notice> selectAllNotice(int currentPage) {
		List<Notice> nList = nDao.selectList(session, currentPage);
		return nList;
	}

	public Notice selectOneByNo(int noticeNo) {
		Notice notice = nDao.selectOne(session, noticeNo);
		return notice;
	}

	public int updateNotice(Notice notice) {
		int result = nDao.updateNotice(session, notice);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		int result = nDao.deleteNotice(session, noticeNo);
		return result;
	}
	
	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.getTotalCount");
		return totalCount;
	}

}







