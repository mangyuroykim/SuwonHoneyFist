package org.SuwonHoneyFist.day05.array;

public class Exam_DeepCopy {
	public static void main(String [] args) {
		// 배열 복사 중 깊은 복사
		int [] arrs = {0, 1, 4, 9};
		int [] copy = new int[4];
		for(int i =0; i < arrs.length; i++) {
			copy[i] = arrs[i]; //일일히 넣어 줘야함 그래야 새로운 공간에 복사되서 들어감
		}
		copy[1] = 11;
		for(int i : copy) {
			System.out.print(i + " ");
		}
		 System.out.println();
		for(int i : arrs) {
			System.out.print(i + " ");
		}
	}
}
