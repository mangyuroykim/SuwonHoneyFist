package com.benq.spring.member.store.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.benq.spring.member.domain.MemberVO;
import com.benq.spring.member.store.MemberStore;

@Repository
public class MemberStoreImpl implements MemberStore{

	@Override
	public int insertMember(SqlSession session, MemberVO member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public MemberVO checkMemberLogin(SqlSession session, MemberVO member) {
		MemberVO result = session.selectOne("MemberMapper.checkMemberLogin", member);
		return result;
	}

	@Override
	public MemberVO selectOneById(SqlSession session, String memberId) {
		MemberVO member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

}
