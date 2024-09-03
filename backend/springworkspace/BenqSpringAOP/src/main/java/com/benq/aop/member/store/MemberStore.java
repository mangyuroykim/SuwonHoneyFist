package com.benq.aop.member.store;

import com.benq.aop.member.domain.MemberVO;

public interface MemberStore {

	int insertMember(MemberVO member);

	MemberVO checkLogin(MemberVO member);

}
