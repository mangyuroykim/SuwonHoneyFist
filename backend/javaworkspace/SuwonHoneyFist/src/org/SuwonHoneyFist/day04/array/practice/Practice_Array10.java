package org.SuwonHoneyFist.day04.array.practice;

import java.util.Scanner;

public class Practice_Array10 {
	public static void main(String[] args) {
//		주민등록번호 성별자리 이후부터 *로 가리고 출력하세요.
//		단, 원본 배열 값은 변경 없이 배열 복사본으로 변경하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) :");
		String idNum = sc.next();
		char [] idNums = new char[idNum.length()];
		for(int i = 0; i < idNums.length; i++) {
			idNums[i] = idNum.charAt(i);
		}
		char [] copy = new char[idNums.length];
		for(int i = 0; i < idNums.length; i++) {
//			copy[i] = idNums[i];
			if(i <8) {
				copy[i] = idNums[i];
			}else {
				copy [i] = '*';
			}
		}
		for(char num : copy) {
			System.out.print(num);
		}
	}
}
