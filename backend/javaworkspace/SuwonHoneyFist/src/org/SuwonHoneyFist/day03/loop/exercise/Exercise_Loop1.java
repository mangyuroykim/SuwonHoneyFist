package org.SuwonHoneyFist.day03.loop.exercise;

import java.util.Scanner;

public class Exercise_Loop1 {
	public static void main(String[] args) {
		// 반복문_실습문제_01
		// 1번
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		// 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		Scanner sc = new Scanner(System.in);//사용자로부터 입력받기 위한 준비
		System.out.print("정수 입력 : "); // 가이드 메시지
		// 정수 입력 : 5
		// 1 2 3 4 5
		int input =sc.nextInt(); //정수하나 입력 받기 위한 명령어, 입력받은 후 input에 저장
		// 1미만의 숫자가 입력되는지 체크
		if(input >=1) {
			// 1이상의 숫자가 입력됨
			// 1부터 입력한 숫자까지의 모든 숫자 출력
			for(int i = 1; i <=input; i++) { //조건식의 최대값 만큼 i가 출력이 되므로 최대값을 입력한 값으로 변경
				System.out.print(i + " ");   //내가 입력한 숫자까지 1부터 출력되게 됨.
			}
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
//		int number;
//		do {
//			System.out.println("숫자를 입력해주세요 : ");
//			number = sc.nextInt();
//			if (number < 1) {
//				System.out.println("1 이상의 숫자를 입력해주세요");
//			}
//		} while (number < 1);
//
//		int i = 1;
//		do {
//			System.out.print(i + " "); // print를 사용하여 한 줄에 출력
//			i++;
//		} while (i <= number);
	}
}
