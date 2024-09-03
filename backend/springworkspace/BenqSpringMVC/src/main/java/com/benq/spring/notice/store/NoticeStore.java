package com.benq.spring.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.benq.spring.notice.domain.NoticeVO;

public interface NoticeStore {
	/**
	 * 공지사항 등록 Store
	 * @param session
	 * @param notice
	 * @return int
	 */
	int insertNotice(SqlSession session, NoticeVO notice);

	
	/**
	 * 공지사항 목록조회 Store
	 * @return List<NoticeVO>
	 */
	List<NoticeVO> selectList(SqlSession session, int currentPage);



	/**
	 * 공지사항 상세조회 Store
	 * @param session
	 * @param noticeNo
	 * @return NoticeVO
	 */
	NoticeVO selectOneByNo(SqlSession session, int noticeNo);


	/**
	 * 공지사항 삭제 Store
	 * @param session
	 * @param noticeNo
	 * @return int
	 */
	int deleteNotice(SqlSession session, Integer noticeNo);


	
	/**
	 * 공지사항 전체 게시물 갯수 Store
	 * @param session
	 * @return int
	 */
	int getTotalCount(SqlSession session);

	
	/**
	 * 공지사항 수정 Store
	 * @param session
	 * @param notice
	 * @return int
	 */
	int updateNotice(SqlSession session, NoticeVO notice);


	List<NoticeVO> selectSearchList(SqlSession session, Map<String, String> paramMap);


}
