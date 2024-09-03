package org.SuwonHoneyFist.day05.array;

public class Exam_HallowCopy {
	public static void main(String [] args) {
		//	배열의 복사 중 얕은 복사
		int [] arrs = new int[4];
		for(int i = 0; i < arrs.length; i++) {
			arrs[i] = i*i;
			
		}
		// for -each문
		// 원래
		// for(int i = 0; i < arrs.length; i++) {
		int [] copy = arrs; // 배열 얕은 복사
		copy[1] =11;		// 두 번째 값 변경
		for(int i : arrs) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i : copy) {
			System.out.print(i + " ");
		}
		
	}
}
