package com.benq.spring.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benq.spring.member.domain.MemberVO;
import com.benq.spring.member.service.MemberService;
import com.benq.spring.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession session;

	@Override
	public int insertMember(MemberVO member) {
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) {
		int result = mStore.updateMember(session, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		int result = mStore.deleteMember(session, memberId);
		return result;
	}

	@Override
	public MemberVO checkMemberLogin(MemberVO member) {
		MemberVO result = mStore.checkMemberLogin(session, member);
		return result;
	}

	@Override
	public MemberVO selectOneById(String memberId) {
		MemberVO member = mStore.selectOneById(session, memberId);
		return member;
	}

}















