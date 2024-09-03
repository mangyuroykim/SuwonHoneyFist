package com.SuwonHoneyFist.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.SuwonHoneyFist.common.JDBCTemplate;
import com.SuwonHoneyFist.member.model.dao.MemberDAO;
import com.SuwonHoneyFist.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}
	public int insertMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = mDao.insertMember(conn, member);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateMember(Member member) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = mDao.updateMember(conn, member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteMember(String memberID) {
		Connection conn = null;
		int result = 0;
		
		try {
				conn = JDBCTemplate.getConnection();
				result = mDao.deleteMember(conn, memberID);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return result;
	}
	
	public Member checkLogin(Member member) {
		Connection conn = null;
		Member mOne = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			mOne = mDao.checkLogin(conn, member);
			System.out.println(mOne.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
	}
	
	public Member selectOneById(String memberID) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			member = mDao.selectOnebyId(conn, memberID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}
	

}
