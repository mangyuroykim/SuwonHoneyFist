package org.SuwonHoneyFist.day05.dimarray.exercise;

import java.util.Scanner;

public class Exercise_DimArray1 {
	public static void main(String[] args) {
		/** 이차원배열의 크기를 1~10까지 입력 받아
		 * 랜덤으로 알파벳 소문자 넣기
		 * 단, 범위를 벗어나면 "반드시 1~10사이의
		 * 정수를 입력 받도록 작성하시오.
		 * 2차원 배열을 만들어각  자리에 랜덤값을 넣으면됨
		 * char형은 숫자를 더해서 문자를 표현할 수 있음
		 * char형 97은 'a'이고 1을 더하면 'b' 된다.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("1~10 사이의 정수를 입력 해주세요 : ");
		int num = sc.nextInt();
		if(num < 1 || num > 10) {
			System.out.println("반드시 1~10 사이의 정수를 입력해주세요");
			System.out.print("1~10 사이의 정수를 입력 해주세요 : ");
			num = sc.nextInt();
		} else {
			char[][] nums = new char[num][num];
			for(int i = 0; i < nums.length; i++ ) {
				for(int j = 0; j < nums[i].length; j++) {
					char random = ()
				}
			}
			//포기//
		}
		
		
//			int [][] nums = new int[num][num];	
	}
}
