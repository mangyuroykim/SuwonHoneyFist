package com.benq.spring.reply.store.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.benq.spring.reply.domain.ReplyVO;
import com.benq.spring.reply.store.ReplyStore;

@Repository
public class ReplyStoreImpl implements ReplyStore {

	@Override
	public int insertReply(SqlSession session, ReplyVO reply) {
		int result = session.insert("ReplyMapper.insertReply", reply);
		return result;
	}

	@Override
	public List<ReplyVO> selectReplyList(SqlSession session, int refNoticeNo) {
		List<ReplyVO> rList = session.selectList("ReplyMapper.selectReplyList", refNoticeNo);
		return rList;
	}

	@Override
	public int updateReply(SqlSession session, ReplyVO reply) {
		int result = session.update("ReplyMapper.updateReply", reply);
		return result;
	}

	@Override
	public int deleteReply(SqlSession session, Integer replyNo) {
		int result = session.delete("ReplyMapper.deleteReply", replyNo);
		return result;
	}

}
