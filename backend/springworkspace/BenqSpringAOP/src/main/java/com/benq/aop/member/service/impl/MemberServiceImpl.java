package com.benq.aop.member.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import com.benq.aop.member.domain.MemberVO;
import com.benq.aop.member.service.MemberService;
import com.benq.aop.member.store.MemberStore;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private	MemberStore mStore;

	
	public int insertMember(MemberVO member) {
		int result = mStore.insertMember(member);
		return result;
	}


	@Override
	public MemberVO checkLogin(MemberVO member) {
		MemberVO loginMember = mStore.checkLogin(member);
		return loginMember;
	}
}
