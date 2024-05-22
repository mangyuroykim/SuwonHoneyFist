package org.SuwonHoneyFist.day04.array.practice;

import java.util.Scanner;

public class Practice_Array6 {
	public static void main(String[] args) {
//		“월“ ~ “일”까지 초기화된 문자열 배열을 만들고 0부터 6까지 숫자를 입력 받아
//		입력한 숫자와 같은 인덱스에 있는 요일을 출력하고
//		범위에 없는 숫자를 입력 시 “잘못 입력하셨습니다“를 출력하세요.
		// 요일 문자 배열을 만들어서
		// 0을 입력하면 월요일, 4를 입력하면 금요일이 출력되도록하고
		// 0 ~ 6 이외에 숫자를 입력하면 잘못입력하셨습니다를 출력하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		if (num < 0 || num > 6) {
			System.out.print("잘못 입력 하셨습니다.");
		}else {
			String[] day = {"월요일","화요일","수요일","목요일","금요일","토요일","일요일"};
				System.out.print(day[num]);
		}
	}
}
