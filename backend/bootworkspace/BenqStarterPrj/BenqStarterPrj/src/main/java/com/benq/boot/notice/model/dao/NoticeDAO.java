package com.benq.boot.notice.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.benq.boot.notice.model.vo.Notice;


@Mapper
public interface NoticeDAO {
	

    int insertNotice(Notice notice);
	/**
	 * 공지사항 상세조회 DAO
	 * @param notice
	 * @return Notice
	 */
    Notice selectOne(Integer noticeNo);
    /**
     * 공지사항 목록 조회 DAO
     * @param currentPage
     * @return
     */
    List<Notice> selectList(Integer currentPage);
    
    /**
     * 전체 게시물 갯수 DAO
     * @return int
     */
	int getTotalCount();
	
	/**
	 * 공지사항 수정 DAO
	 * @param notice
	 * @return int
	 */
	int updateNotice(Notice notice);
	
	/**
	 * 공지사항 삭제 DAO
	 * @param noticeNo
	 * @return int
	 */
	int deleteNotice(Integer noticeNo);
}