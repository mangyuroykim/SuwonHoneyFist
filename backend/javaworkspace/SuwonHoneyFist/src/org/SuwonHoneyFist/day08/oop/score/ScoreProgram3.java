package org.SuwonHoneyFist.day08.oop.score;

import java.util.Scanner;

public class ScoreProgram3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		while(true) {
			int choice = student.printMenu();
			switch(choice) {
			case 1 :
				student.inputScore();
				break;
			case 2 :
				student.printScore();
			case 3 :
				student.displayMsg("프로그램을 종료합니다.");
			default :
				student.displayMsg("1 ~ 3 사이의 수를 입력해주세요.");
			}
		}
	}

}
