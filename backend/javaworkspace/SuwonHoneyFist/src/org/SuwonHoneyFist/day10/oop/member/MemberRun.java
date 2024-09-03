package org.SuwonHoneyFist.day10.oop.member;

public class MemberRun {
	public static void main(String[] args) {
		// 회원관리 프로그램
		// 1. 회원가입
		// 2. 회원검색
		// 3. 회원정보보기
		Viewmember view = new Viewmember();
		ManageMember mng = new ManageMember();
		end: while (true) {

			int menu = view.printmenu();
			switch (menu) {
			case 1:
				Member member = view.inputMember();
				mng.registerMember(member);
				break;
			case 2:
				// 회원검색 기능 구현 필요
				break;
			case 3:
				Member[] members = mng.allMember();
				view.displayMemberList(members);
				break;
			case 4:
				view.printMessage("프로그램을 종료하겠습니다.");
				break end;
			default:
				view.printMessage("잘못 입력하셨습니다.");
			}
		}
	}
}
