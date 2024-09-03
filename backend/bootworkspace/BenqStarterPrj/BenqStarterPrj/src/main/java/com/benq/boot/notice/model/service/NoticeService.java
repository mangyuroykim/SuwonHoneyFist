package com.benq.boot.notice.model.service;


import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.web.multipart.MultipartFile;

import com.benq.boot.notice.model.vo.Notice;
import com.benq.boot.notice.model.vo.NoticeFile;

public interface NoticeService {

	
	/**
	 * 공지사항 상세조회 Service
	 * @param noticeNo
	 * @return Notice
	 */
	Notice selectOne(Integer noticeNo);
	
	/**
	 * 공지사항 목록조회 Service
	 * @param currentPage
	 * @param rowBounds
	 * @return List<Notice>
	 */
	List<Notice> selectList(Integer currentPage, RowBounds rowBounds);

	/**
	 * 공지사항 등록 Service
	 * @param inputNotice
	 * @param uploadFile
	 * @return int
	 */
	int insertNotice(Notice inputNotice, MultipartFile uploadFile) throws IllegalStateException, IOException;

	
	/**
	 * 전체 게시물 갯수 Service
	 * @return int
	 */
	int getTotalCount();
	
	/**
	 * 공지사항 수정 Service
	 * @param notice
	 * @return int
	 * @throws Exception 
	 */
	int updateNotice(Notice notice, MultipartFile reloadFile) throws Exception;

	
	/**
	 * 공지사항 삭제 Service
	 * @param noticeNo
	 * @return int
	 */
	int deleteNotice(Integer noticeNo);
	


	
	/**
	 * 공지사항 파일 등록 Service
	 * @param noticeFile
	 * @return int
	 */
	//int insertNoticeFile(NoticeFile noticeFile) throws IllegalStateException, IOException;
	
	
	
	
}
