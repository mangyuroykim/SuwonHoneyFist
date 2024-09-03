package com.benq.spring.notice.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.benq.spring.notice.domain.NoticeVO;
import com.benq.spring.notice.store.NoticeStore;

@Repository
public class NoticeStoreImpl implements NoticeStore{

	@Override
	public int insertNotice(SqlSession session, NoticeVO notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public List<NoticeVO> selectList(SqlSession session, int currentPage) {
		int limit = 10;
		// currentPage : 1, offset : 0 / 10 = 0
		// currentPage : 2, offset : 10 / 10 = 1
		// currentPage : 3, offset : 20 / 10 = 2
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<NoticeVO> nList = session.selectList("NoticeMapper.selectList", null, rowBounds);
		return nList;
	}

	@Override
	public NoticeVO selectOneByNo(SqlSession session, int noticeNo) {
		NoticeVO notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	@Override
	public int deleteNotice(SqlSession session, Integer noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	@Override
	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.getTotalCount");
		return totalCount;
	}

	@Override
	public int updateNotice(SqlSession session, NoticeVO notice) {
		int result = session.insert("NoticeMapper.updateNotice", notice);
		return result;
	}

	@Override
	public List<NoticeVO> selectSearchList(SqlSession session, Map<String, String> paramMap) {
		List<NoticeVO> searchList = session.selectList("NoticeMapper.selectSearchList", paramMap);
		return searchList;
	}



}
