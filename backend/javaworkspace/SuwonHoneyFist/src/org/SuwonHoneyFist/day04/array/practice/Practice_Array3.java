package org.SuwonHoneyFist.day04.array.practice;

import java.util.Scanner;

public class Practice_Array3 {
	public static void main(String[] args) {
		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
		// 1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 값을 입력하세요 : ");
		int num = sc.nextInt();

		if (num <= 0) {
			System.out.println("양의 정수를 입력하세요.");
		} else {
			int[] arrs = new int[num];

			for (int i = 0; i < num; i++) {
				arrs[i] = i + 1; 
				System.out.print(arrs[i] + " ");

			}
		}
	}
}
