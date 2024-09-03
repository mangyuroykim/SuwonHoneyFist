package kr.or.iei;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[5];
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번째 " + "정수를 입력하세요 : ");
			nums[i] = sc.nextInt();
		}
		// 3. 정렬하기 - 버블 정렬 알고리즘
		// 1 - 2 , 2 - 3, 3 - 4, 4 - 5
		// 최대값을 맨 오른쪽에 위치하면서 정렬 하는 알고리즘
		// 1 - 2, 2 - 3, 3 - 4
		// 1 - 2, 2 - 3
		// 1 - 2
//		for() {
//			for() { int j = 0; j < 4; j++) {
//				if (nums[0] > nums[1]) {
//					int temp = nums[1];
//					nums[1] = nums[0];
//					nums[0] = temp;
//				}
//			}
//		}

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < (nums.length - 1) - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}

			}
		}
		System.out.print("정렬된 결과 : ");

		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println("\n정렬 후 첫번째 수와 마지막수의 합 : " + (nums[0] + nums[4]));
	}
}
