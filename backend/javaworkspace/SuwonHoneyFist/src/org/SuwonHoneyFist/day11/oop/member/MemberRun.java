package org.SuwonHoneyFist.day11.oop.member;

public class MemberRun {
    public static void main(String[] args) {
        ViewMember view = new ViewMember();
        ManageMember mng = new ManageMember();
        while (true) {
            int choice = view.mainMenu();
            switch (choice) {
                case 1:
                    // 회원가입
                    Member member = view.inputMember();
                    mng.insertMember(member); // 저장완료
                    break;
                case 2:
                    // 회원검색(이메일)
                    String email = view.inputEmail("검색"); // 변수명 변경
                    member = mng.searchOneByEmail(email); // email 변수 사용
                    view.printOneMember(member);
                    break;
                case 3:
                    // 회원 전체정보 출력
                    Member[] members = mng.getAllMembers();
                    view.printAllMembers(members);
                    break;
                case 4:
                    // 회원 정보 수정
                    email = view.inputEmail("수정"); // 변수명 변경
                    member = mng.searchOneByEmail(email); // email 변수 사용
                    if (member != null) {
                        Member updatedMember = view.modifyMember(email); // email 전달
                        view.updateMember(updatedMember); // members 배열 전달
                        view.displayMessage("회원 정보가 수정되었습니다.");
                    } else {
                        view.displayMessage("해당 이메일의 회원을 찾을 수 없습니다.");
                    }
                    break;
                case 5:
                    // 회원 삭제 기능을 여기에 추가할 수 있습니다.
                    break;
                case 0:
                    view.displayMessage("프로그램을 종료합니다");
                    return; // 프로그램 종료
                default:
                    view.displayMessage("잘못입력하셨습니다.");
            }
        }
    }
}
