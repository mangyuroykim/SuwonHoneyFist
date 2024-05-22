package org.SuwonHoneyFist.day02.operator;

import java.util.Scanner;

public class Exam_Arithmetic {
	public static void main(String[] args) {
		// 산술연산
		// +, -, *, /, %
		// % : 나머지를 구해주는 연산자
		//문제 1
		// 초 단위의 정수를 입력받고, 몇시간, 몇분, 몇초인지 출력하는 프로그램을 작성하여라.
		System.out.println("정수를 입력하세요:");
		Scanner scanner = new Scanner(System.in);
		int time = scanner.nextInt();
		// 3000 -> ?시간, ?분, ?초
		int second = time %60; //60으로 나눈 나머지는 초
		int minute = (time / 60) % 60; //60으로 나눈 몫을 다시 60으로 나눈 나머지는 분
		int hour = (time / 60) /60; // 60으로 나눈 몫을 다시 60으로 나눈 몫은 시간
	
		System.out.println(time + "초는");
		System.out.println(hour + "시간,");
		System.out.println(minute + "분,");
		System.out.println(second + "초입니다.");

		scanner.close();
	}

}
