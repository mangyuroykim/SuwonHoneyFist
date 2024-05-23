package org.SuwonHoneyFist.day05.exception.exercise;

import java.util.Scanner;

public class Exercise_Exception3 {
public static void main(String[] args) {
	// 문제3
	// 배열의 인덱스가 범위를 벗어날 때
	// 발생하는 ArrayIndexOutOfBoundsException을
	// 처리하는 프로그램을 작성하시오.
	int [] arrs = new int[5];
	try {
		System.out.println(intArrs[5]);
	}catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("배열의 인덱스가 범위를 벗어 났습니다");
		
//
//	System.out.print("행 인덱스를 입력하세요 : ");
//	int num1 = sc.nextInt();
//	System.out.print("열 인덱스를 입력하세요 : ");
//	int num2 = sc.nextInt();
//	if(num1 < 0 || num1 < arrs.length || num2 < 0 || num2 >= arrs[0].length) {
//		System.out.print("인덱스 범위를 벗어 났습니다");
	}
}
}
