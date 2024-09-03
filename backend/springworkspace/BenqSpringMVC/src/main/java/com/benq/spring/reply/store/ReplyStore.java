package com.benq.spring.reply.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.benq.spring.reply.domain.ReplyVO;

public interface ReplyStore {
	
	
	/**
	 * 공지사항 댓글 등록 Store
	 * @param session
	 * @param reply
	 * @return int
	 */
	int insertReply(SqlSession session, ReplyVO reply);

	List<ReplyVO> selectReplyList(SqlSession session, int refNoticeNo);
	
	/**
	 * 공지사항 댓글 수정 Store
	 * @param session
	 * @param reply
	 * @return int
	 */
	int updateReply(SqlSession session, ReplyVO reply);
	
	/**
	 * 공지사항 댓글삭제 Store
	 * @param session
	 * @param replyNo
	 * @return int
	 */
	int deleteReply(SqlSession session, Integer replyNo);

}
