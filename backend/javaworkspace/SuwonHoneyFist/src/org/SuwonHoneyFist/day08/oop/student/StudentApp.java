package org.SuwonHoneyFist.day08.oop.student;

import org.SuwonHoneyFist.day08.oop.score.Student;

public class StudentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ManageStudent student = new ManageStudent();
		ViewStudent view = new ViewStudent();
		end :
		while(true) {
			int choice = view.printMenu();
			switch(choice) {
			case 1 :
				student.inputScore();
				break;
			case 2 :
				student.printScore();
			case 3 :
				view.displayMsg("프로그램을 종료합니다.");
				break end;
			default :
				view.displayMsg("1 ~ 3 사이의 수를 입력해주세요.");
			}
		}
	}

}
