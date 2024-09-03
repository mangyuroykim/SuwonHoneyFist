package com.SuwonHoneyFist.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.SuwonHoneyFist.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberID());
		pstmt.setString(2, member.getMemberPW());
		pstmt.setString(3, member.getMemberNAME());
		pstmt.setString(4, member.getMemberGENDER());
		pstmt.setInt(5, member.getAge());
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getPhone());
		pstmt.setString(8, member.getAddress());
		pstmt.setString(9, member.getHobby());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	public Member checkLogin(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member mOne = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberID());
		pstmt.setString(2, member.getMemberPW());
		rset = pstmt.executeQuery();
		if(rset.next()) {
			mOne = new Member();
			mOne.setMemberID(rset.getString("MEMBER_ID"));
			mOne.setMemberNAME(rset.getString("MEMBER_NAME"));
		}
		pstmt.close();
		rset.close();
		return mOne;
	}

	public int deleteMember(Connection conn, String memberID) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberID);
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	public Member selectOnebyId(Connection conn, String memberID) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberID);
		rset = pstmt.executeQuery();
		if (rset.next()) {
		    member = new Member();
		    member.setMemberID(rset.getString("MEMBER_ID"));
		    member.setMemberNAME(rset.getString("MEMBER_NAME"));
		    member.setMemberGENDER(rset.getString("GENDER"));
		    member.setAge(rset.getInt("AGE"));
		    member.setEmail(rset.getString("EMAIL"));
		    member.setPhone(rset.getString("PHONE"));
		    member.setAddress(rset.getString("ADDRESS"));
		    member.setHobby(rset.getString("HOBBY"));
		    member.setRegDate(rset.getDate("REG_DATE"));
		}
		
		return member;
	}

	public int updateMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="UPDATE MEMBER_TBL SET EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getEmail());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getHobby());
		pstmt.setString(5, member.getMemberID());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
//	public int updateMember(Member member, Connection conn) throws SQLException {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String query= "UPDATE MEMBER_TBL SET EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
//		pstmt = conn.prepareStatement(query);
//		pstmt.setString(1, member.getMemberEmail());
//		pstmt.setString(2, member.getMemberPhone());
//		pstmt.setString(3, member.getMemberAddress());
//		pstmt.setString(4, member.getMemberHobby());
//		pstmt.setString(5, member.getMemberId());
//		
//		result = pstmt.executeUpdate();
//		
//		pstmt.close();
//		
//		return result;
//	}
}
