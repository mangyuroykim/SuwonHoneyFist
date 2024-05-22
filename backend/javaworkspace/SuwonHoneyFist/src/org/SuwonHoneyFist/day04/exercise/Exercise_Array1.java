package org.SuwonHoneyFist.day04.exercise;

import java.util.Scanner;

public class Exercise_Array1 {
	public static void main(String[] args) {
		// 배열의 length 필드를 이용하여 배열 크기만큼 정수를
		// 입력받고 평균을 구하는 프로그램을 작성하라.
		// 단, 배열의 크기는 5이다.
		// 정수 입력 : 24
		// 정수 입력 : 10
		// 정수 입력 : 23
		// 정수 입력 : 5
		// 정수 입력 : 7
		// 평균 :
		int [] nums = new int[5];
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			System.out.print("정수 하나 입력 : ");
			nums[i] = sc.nextInt();
			sum += nums[i];
		}
//		for(int i = 0; i < 5; i++) {
//			/*sum = nums[i]; */
//			sum += nums[i];
//		}
//		sum = nums[0]
//		sum = nums[0]+nums[1]
//		sum = nums[0]+nums[1]+nums[2]
//		sum = nums[0]+nums[1]+nums[2]+nums[3]
//		sum = nums[0]+nums[1]+nums[2]+nums[3]+nums[4];
		System.out.println("평균 :" + (double)sum/5.0); // 둘 중 하나만 해도 됨
														// 자동 형 변환되기 대문이
		
		
		
		//내가한거//
//		int[] nums = new int[5];
//		Scanner sc= new Scanner(System.in);
//		for(int num = 0; num < nums.length; num++) {
//		System.out.print("정수를 입력해 주세요 : ");
//		int i = sc.nextInt();
//		}

		// 정수 입력 5번하는데 배열에 저장하시고
		// 배열에 있는 값을 꺼내서 더한 후 평균 구해서 출력
		
		//배열 없이 가능 ㅇㅇ
		// 배열을 사용해서 해보셔라..
		
		
	}
}
