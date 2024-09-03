package com.benq.soupring.member.store;

import org.apache.ibatis.session.SqlSession;

import com.benq.soupring.member.domain.MemberVO;

public interface MemberStore {

		int insertMember(SqlSession session, MemberVO member);
}
