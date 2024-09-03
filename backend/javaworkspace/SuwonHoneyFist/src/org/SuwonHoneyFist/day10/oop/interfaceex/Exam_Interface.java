package org.SuwonHoneyFist.day10.oop.interfaceex;

public class Exam_Interface {
//	PhoneInterface phone = new PhoneInterface();
//	PhoneInterface phone = new SamsungPhone();
//	추상 클래스와 마찬가지로 객체 생성 불가
//	자식 클래스 객체로 업캐스팅하여 사용
	public static void main(String[] args) {
		PhoneInterface phone = new SamsungPhone();
		phone.PrintLogo();
		phone.sendCall();
		
	}
}
