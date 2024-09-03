package com.benq.spring.reply.service;

import java.util.List;

import com.benq.spring.reply.domain.ReplyVO;

public interface ReplyService {
	
	
	/**
	 * 공지사항 댓글 등록 Service
	 * @param reply
	 * @return int
	 */
	int insertReply(ReplyVO reply);

	
	/**
	 * 공지사항 댓글 목록 조회 Service
	 * @param noticeNo 
	 * @return List<ReplyVO>
	 */
	List<ReplyVO> selectReplyList(int refnoticeNo);


	/**
	 * 공지사항 댓글 수정 Service
	 * @param reply
	 * @return int
	 */
	int updateReply(ReplyVO reply);

	
	/**
	 * 공지사항 댓글 삭제 Service
	 * @param replyNo
	 * @return int
	 */
	int deleteReply(Integer replyNo);

}
