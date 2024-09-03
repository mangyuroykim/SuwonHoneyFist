package org.SuwonHoneyFist.day08.oop.student;

import java.util.List;
import java.util.Scanner;

import org.SuwonHoneyFist.day12.collection.student.Student;

public class ViewStudent {
	public static int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 메인 메뉴 =======");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 종료");
		System.out.print("선택 >>");
		int choice = sc.nextInt();
		return choice;
	}
	public void displayMsg(String message) {
		// message = "프로그램을 종료합니다.";
		System.out.println(message);
	}
	public Student inputStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	public Student modifyStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public String inputName(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public void displayStudents(List<Student> stdList) {
		// TODO Auto-generated method stub
		
	}
	public void displayMsg(List<Student> sList) {
		// TODO Auto-generated method stub
		
	}
	public void displyaMsg(String passResult) {
		// TODO Auto-generated method stub
		
	}
}
