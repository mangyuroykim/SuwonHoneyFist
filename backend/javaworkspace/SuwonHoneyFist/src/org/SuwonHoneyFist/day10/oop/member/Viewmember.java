package org.SuwonHoneyFist.day10.oop.member;

import java.util.Scanner;

public class Viewmember {

	public int printmenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원관리 프로그램 =====");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원검색");
		System.out.println("3. 회원정보보기");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 : ");
		return sc.nextInt();
	}

	public void printMessage(String msg) {
		System.out.println(msg);
	}

	public Member inputMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원가입 =====");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 비우기
		System.out.print("이메일 : ");
		String memberEmail = sc.next();
		System.out.print("전화번호 : ");
		String memberPhone = sc.next();
		sc.nextLine(); // 입력 버퍼 비우기
		System.out.print("주소 : ");
		String memberAddress = sc.nextLine();
		// 다 적었으면 Member의 인스턴스에 모두 넣어보자
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		member.setMemberAge(memberAge);
		member.setMemberEmail(memberEmail);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		return member;
	}

	public void displayMemberList(Member[] members) {
		System.out.println("===== 회원 전체정보 보기 =====");
		for (Member member : members) {
			if (member != null) {
				System.out.printf("아이디 : %s, 이름 : %s, 나이 : %d\n", member.getMemberId(), member.getMemberName(),
						member.getMemberAge());
			}
		}
	}

	public void displayMember(Member member) {
		System.out.println("===== 회원 정보 보기 =====");
		System.out.printf("아이디 : %s, 이름 : %s, 나이 : %d\n", member.getMemberId(), member.getMemberName(),
				member.getMemberAge());
	}
	public String inputMemberId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 아이디 입력 : ");
		String memberId = sc.next();
		return memberId;
		
	}
}
