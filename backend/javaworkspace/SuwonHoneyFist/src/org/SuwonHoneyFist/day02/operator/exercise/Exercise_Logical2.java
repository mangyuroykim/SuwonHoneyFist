package org.SuwonHoneyFist.day02.operator.exercise;

import java.util.Scanner;

public class Exercise_Logical2 {
	public static void main(String [] args) {
//		char a = 'A'+1;
//		char는 '' 쓰고 String은 "" 씀
//		a = 'a'+1;
//		System.out.println(a);
		//입력받은 문자가 대문자인지 소문자인지 확인하세요!
		//문자를 입력해주세요 : a
		//문자 출력 : a
		//영어 대문자 확인 : false
		//몇부터 몇사이의 숫자인가? : 65 ~ 90
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력해주세요 ; ");
		char word;
		boolean result;
		word = sc.next().charAt(0);
		result = (word >= 65) && (word <= 90);
		System.out.println("영어 대문자 확인 : " + result);
	
	}

}
