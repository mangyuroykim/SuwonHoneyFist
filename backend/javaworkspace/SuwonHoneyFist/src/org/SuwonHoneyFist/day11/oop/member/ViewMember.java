package org.SuwonHoneyFist.day11.oop.member;

import java.util.Scanner;

public class ViewMember {
    private Scanner sc = new Scanner(System.in);

    public int mainMenu() {
        System.out.println("====== 회원관리 프로그램 ======");
        System.out.println("1. 회원가입");
        System.out.println("2. 회원검색");
        System.out.println("3. 회원 전체정보 조회");
        System.out.println("4. 회원정보수정");
        System.out.println("5. 회원정보삭제");
        System.out.println("0. 프로그램 종료");
        System.out.print("메뉴 선택: ");
        return sc.nextInt();
    }

    public Member inputMember() {
        System.out.println("=== 회원가입 ===");
        System.out.print("이름: ");
        String memberName = sc.next();
        System.out.print("이메일: ");
        String memberEmail = sc.next();
        System.out.print("전화번호: ");
        String memberPhone = sc.next();
        System.out.print("주소: ");
        String memberAddress = sc.next();
        return new Member(memberName, memberEmail, memberPhone, memberAddress);
    }

    public Member modifyMember(String memberEmail) {
        System.out.println("=== 회원정보 수정 ===");
        System.out.print("이름: ");
        String memberName = sc.next();
        System.out.print("전화번호: ");
        String memberPhone = sc.next();
        System.out.print("주소: ");
        String memberAddress = sc.next();
        return new Member(memberName, memberEmail, memberPhone, memberAddress);
    }

    public String inputEmail() {
        System.out.print("이메일 입력: ");
        return sc.next();
    }

    public void printOneMember(Member member) {
        if (member != null) {
            System.out.println("=== 회원 정보 ===");
            System.out.println(member);
        } else {
            System.out.println("회원 정보를 찾을 수 없습니다.");
        }
    }

    public void printAllMembers(Member[] members) {
        System.out.println("=== 전체 회원 정보 ===");
        for (Member member : members) {
            if (member != null) {
                System.out.println(member);
            }
        }
    }

    public String inputEmail(String category) {
        System.out.print(category + "할 회원의 이메일 입력: ");
        return sc.next();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void updateMember(Member member) {
        ManageMember mng = new ManageMember();
        mng.updateMember(member);
    }
}
