package com.SuwonHoneyFist.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.SuwonHoneyFist.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(SqlSession conn, Member member) {
		int result = conn.insert("MemberMapper.insertMember",member);
		return result;
	}

	public Member checkLogin(SqlSession conn, Member member) {
		Member mOne = conn.selectOne("MemberMapper.checkLogin", member);
		return mOne;
	}

	public Member selectOneById(SqlSession conn, String memberID) {
		Member member = conn.selectOne("MemberMapper.selectOneById", memberID);
		return null;
	}


}
