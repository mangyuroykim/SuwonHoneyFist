package com.benq.spring.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benq.spring.notice.domain.NoticeVO;
import com.benq.spring.notice.service.NoticeService;
import com.benq.spring.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private SqlSession session;
	@Autowired
	private NoticeStore nStore;
	
	@Override
	public int insertNotice(NoticeVO notice) {
		int result = nStore.insertNotice(session, notice);
		return result;
	}

	@Override
	public List<NoticeVO> selectNoticeList(int currentPage) {
		List<NoticeVO> nList = nStore.selectList(session, currentPage);
		return nList;
	}

	@Override
	public NoticeVO selectOneByNo(int noticeNo) {
		NoticeVO notice = nStore.selectOneByNo(session, noticeNo);
		return notice;
	}

	@Override
	public int deleteNotice(Integer noticeNo) {
		int result = nStore.deleteNotice(session, noticeNo);
		return result;
	}

	@Override
	public int getTotalCount() {
		int totalCount = nStore.getTotalCount(session);
		return totalCount;
	}

	@Override
	public int updateNotice(NoticeVO notice) {
		int result = nStore.updateNotice(session, notice);
		return result;
	}

	@Override
	public List<NoticeVO> searchNoticesByKeyword(Map<String, String> paramMap) {
		List<NoticeVO> searchList = nStore.selectSearchList(session, paramMap);
		return searchList;
	}

}
