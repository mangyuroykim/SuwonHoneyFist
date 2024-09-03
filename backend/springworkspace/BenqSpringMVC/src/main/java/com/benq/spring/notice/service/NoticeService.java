package com.benq.spring.notice.service;

import java.util.List;
import java.util.Map;

import com.benq.spring.notice.domain.NoticeVO;

public interface NoticeService {
	
	/**
	 * 공지사항 등록 Service
	 * @param notice
	 * @return int
	 */
	int insertNotice(NoticeVO notice);

	/**
	 * 공지사항 목록조회 Service
	 * @return List<NoticeVO>
	 */
	List<NoticeVO> selectNoticeList(int currentPage);

	
	/**
	 * 공지사항 상세조회 Service
	 * @param noticeNo
	 * @return NoticeNo
	 */
	NoticeVO selectOneByNo(int noticeNo);

	
	/**
	 * 공지사항 삭제 Service
	 * @param noticeNo
	 * @return int
	 */
	int deleteNotice(Integer noticeNo);

	
	/**
	 * 공지사항 전체 게시물 갯수 Service
	 * @return int
	 */
	int getTotalCount();
	
	/**
	 * 공지사항 수정 Service
	 * @param notice
	 * @return
	 */
	int updateNotice(NoticeVO notice);

	/**
	 * 공지사항 게시물 검색 Service
	 * @param paramMap
	 * @return List
	 */
	List<NoticeVO> searchNoticesByKeyword(Map<String, String> paramMap);
}
