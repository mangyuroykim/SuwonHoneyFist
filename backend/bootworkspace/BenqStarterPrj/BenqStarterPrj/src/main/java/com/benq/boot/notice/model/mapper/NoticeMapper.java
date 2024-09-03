package com.benq.boot.notice.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.benq.boot.notice.model.vo.Notice;
import com.benq.boot.notice.model.vo.NoticeFile;

/*
 *  @Mapper 어노테이션
 *  Mapper 인터페이스 메서드명과
 *  mapper.xml 에 작성한 태그 아이디가 같은 것끼리
 *  연결해주는 어노테이션
 *  
 *  SqlSessionTemplate bean에 의존성 주입받는 코드 작성을 안함.
 *  작성을 안해도 Spring Container에서 알아서 생성 후 사용
 *  2. 네임스페이스.아이디값을 적지 않아도 됨.
 *  3. session에서 사용했었던 메소드(insert, update, ..)
 *   작성하지 않아도 됨.
 *  
 *  꼭 기억해야 하는 것
 *  중요) mapper.xml에서 Mapper인터페이스의 경로를
 *  namespace에 적어주어야 함.
 *  
 */

@Mapper
public interface NoticeMapper {
	

	/**
	 * 공지사항 등록 DAO
	 * @param inputNotice
	 * @return int
	 */
    int insertNotice(Notice inputnotice);
	/**
	 * 공지사항 상세조회 DAO
	 * @param noticeNo
	 * @return Notice
	 */
    Notice selectOne(Integer noticeNo);
    /**
     * 공지사항 목록 조회 DAO
     * @return
     */
    List<Notice> selectList(Integer currentPage, RowBounds rowBounds);
    
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
	
	/**
	 * 공지사항 파일 등록 Mapper
	 * @param noticeFile
	 * @return int
	 */
	int insertNoticeFile(NoticeFile noticeFile);
	
	/**
	 * 공지사항 파일 수정 Mapper
	 * @param noticeFile
	 * @return int
	 */
	int updateNotice(NoticeFile noticeFile);
	
	/**
	 * 공지사항 파일 조회
	 * @param Integer
	 * @return NoticeFile
	 */
	NoticeFile selectNoticeFile(Integer noticeNo);
	
	/**
	 * 공지사항 파일 수정 Mapper
	 * @param NoticeFile
	 * @return int
	 */
	int updateNoticeFile(NoticeFile nFileOne);
}