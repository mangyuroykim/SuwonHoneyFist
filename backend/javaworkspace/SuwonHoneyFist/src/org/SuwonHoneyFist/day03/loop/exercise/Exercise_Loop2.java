package org.SuwonHoneyFist.day03.loop.exercise;

import java.util.Scanner;

public class Exercise_Loop2 {
	public static void main(String [] args) {
		//2번
		//사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		//단, 입력한 수는 1보다 크거나 같아야 합니다.
		Scanner sc = new Scanner(System.in); // 사용자로부터 입력받기 위한 준비
		System.out.print("정수 입력 : ");   // 가이드 메시지
		int input = sc.nextInt(); 			// 정수하나 입력 받기 위한 명령어 입력받은 후 input에 저장
		// 입력한 수가 1보다 큰지 체크
		if(input >= 1) {
			//5 4 3 2 1
			for(int i = input; i >= 1; i--) {
				System.out.print(i + " ");
			}
//		int num;
//		do {
//			System.out.print("숫자를 입력하세요 : ");
//			num = sc.nextInt();
//			if(num < 1) {
//				System.out.print("입력한 수는 1보다 크거나 같아야 합니다.");
//						}
//		
//		}while(num < 1 );
//		
//		System.out.print("거꾸로 출력: ");
//			for(int i = num; i>= 1; i--) {
//			System.out.print(i + " ");
//			
		}
			
		
		}
	}

