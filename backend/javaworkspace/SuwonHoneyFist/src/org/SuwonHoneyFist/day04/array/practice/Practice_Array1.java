package org.SuwonHoneyFist.day04.array.practice;

public class Practice_Array1 {
	public static void main(String[] args) {
		// 문제 1
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 
		// 순서대로 배열 인덱스에 넣은 후 그 값을 출력하세요.
		int[] arrs = new int[10];
//		for(int i = 0; i < 10; i++) {
//			arrs[i] = (i+1);
//		}
//		arrs[0] = 1;
//		arrs[1] = 2;
//		arrs[2] = 3;
//		arrs[3] = 4;
//		arrs[4] = 5;
//		arrs[5] = 6;
//		arrs[6] = 7;
//		arrs[7] = 8;
//		arrs[8] = 9;
//		arrs[9] = 10;
		for(int i = 0; i < 10; i++) {
			arrs[i] = (i+1);
			System.out.print(arrs[i] + " ");
		}
	}
}
