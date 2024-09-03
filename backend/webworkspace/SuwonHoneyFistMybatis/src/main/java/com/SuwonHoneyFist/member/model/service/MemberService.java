package com.SuwonHoneyFist.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.SuwonHoneyFist.common.SqlSessionTemplate;
import com.SuwonHoneyFist.member.model.dao.MemberDAO;
import com.SuwonHoneyFist.member.model.vo.Member;

public class MemberService {
	private SqlSession conn;
	private MemberDAO mDao;
	
	public MemberService() {
		conn = SqlSessionTemplate.getSqlSession();
		mDao = new MemberDAO();
	}

	public int insertMember(Member member) {
		int result = mDao.insertMember(conn, member);
		return result;
	}

	public Member checkLogin(Member member) {
		Member mOne = mDao.checkLogin(conn, member);
		return mOne;
	}

	public Member selectOneById(String memberID) {
		Member member = mDao.selectOneById(conn, memberID);
		return member;
	}
	
	
	}

