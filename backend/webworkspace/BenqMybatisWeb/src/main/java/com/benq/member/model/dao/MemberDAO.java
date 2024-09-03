package com.benq.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.benq.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(SqlSession conn, Member member) {
		int result = conn.insert("MemberMapper.insertMember", member);
		return result;
	}

	public int updateMember(SqlSession conn, Member member) {
		int result = conn.update("MemberMapper.updateMember", member);
		return result;
	}

	public int deleteMember(SqlSession conn, String memberId) {
		int result = conn.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

	public Member checkLogin(SqlSession conn, Member member) {
		Member mOne = conn.selectOne("MemberMapper.checkLogin", member);
		return mOne;
	}

	public Member selectOneById(SqlSession conn, String memberId) {
		Member member = conn.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

}









