package com.SuwonHoneyFist.member.model.vo;

import java.sql.Date;

public class Member {
	
	private String memberID;
	private String memberPW;
	private String memberNAME;
	private String memberGENDER;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date regDate;

	public Member() {}
	
	public Member(String memberID, String memberPW) {
		super();
		this.memberID = memberID;
		this.memberPW = memberPW;
	}

	public Member(String memberID, String memberPW, String memberNAME, String memberGENDER, int age, String email,
			String phone, String address, String hobby) {
		super();
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberNAME = memberNAME;
		this.memberGENDER = memberGENDER;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberPW=" + memberPW + ", memberNAME=" + memberNAME
				+ ", memberGENDER=" + memberGENDER + ", Age=" + age + ", Email=" + email + ", Phone=" + phone
				+ ", Address=" + address + ", Hobby=" + hobby + ", regDate=" + regDate + "]";
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	public String getMemberNAME() {
		return memberNAME;
	}

	public void setMemberNAME(String memberNAME) {
		this.memberNAME = memberNAME;
	}

	public String getMemberGENDER() {
		return memberGENDER;
	}

	public void setMemberGENDER(String memberGENDER) {
		this.memberGENDER = memberGENDER;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
	