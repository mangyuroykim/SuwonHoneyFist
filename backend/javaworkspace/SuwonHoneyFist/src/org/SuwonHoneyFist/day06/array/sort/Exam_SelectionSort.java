package org.SuwonHoneyFist.day06.array.sort;

public class Exam_SelectionSort {
	public static void main(String[] args) {
		// 선택정렬이란?
		// 배열을 전부 검색하여 최소값을 고르고 왼쪽부터 채워나가는 정렬
		// 특징 : 데이터의 양이 적을때, 좋은 성능을 보여주는 정렬
		// 데이터 양이 많을 때 급격한 성능 저하를 보임
		// 배열의 n번 인덱스값을 n+1 ~ 마지막 인덱스까지 비교함.
		// 쭉 비교해서 자기보다 작은 값이랑 자리 맞바꾼다고 보면됨
		// {2, 5, 4, 1, 3}
		// 첫번째 결과 : {1, 5, 4, 2, 3}
		// {1, 5, 4, 2, 3}
		// 두번째 결과 : {1, 2, 4, 5, 3}
		// {1, 2, 4, 5, 3}
		// 세번째 결과 : { 1, 2, 3, 5, 4}
		// { 1, 2, 3, 5, 4}
		// 네번째 결과 : {1, 2, 3, 4, 5}
		int[] arrs = { 2, 5, 4, 1, 3 };
//		int min = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 5; j++) {// 왜냐면 검사할 기준 그 다음꺼랑 비교하는거니까 +1 해야함
				
				int min = i;
				if (arrs[min] > arrs[j]) {
					// 최소값이 나왔을 때, 그때의 자리를 기억하자
					// 그때의 인덱스를 기억하자
					// 니가 최소값이야
					min = j; // 최소값이 정해졌을때의 min을 arrs[min]을 구하면 최소값
				}
//			for(int j = i i >=0; j--) {	}

			}
//		if(arrs[0] > arrs[2]) {
//			//니가 최소값이야
//		}
//		if(arrs[0] > arrs[3) {
//			//니가 최소값이야
//		}
//		if(arrs[0] > arrs[4]) {
//			//니가 최소값이야
//		}
//		int temp = arrs[0];
//		arrs[0] = 최소값;
//		최소값의 자리 = temp;
//	}
//		if(arrs[1] > arrs[2]) {
//			//니가 최소값이야
//		}
//		if(arrs[1] > arrs[3]) {
//			//니가 최소값이야
//		}
//		if(arrs[0] > arrs[4]) {
//			//니가 최소값이야
//		}
//		int temp = arrs[0];
//		arrs[0] = 최소값;
//		최소값의 자리 = temp;
//		
//		if(arrs[1] > arrs[2]) {
//			//니가 최소값이야
//		}
//		if(arrs[1] > arrs[3]) {
//			//니가 최소값이야
//		}
//		if(arrs[0] > arrs[4]) {
//			//니가 최소값이야
//		}
			int temp = arrs[i];
			arrs[i] = arrs[min];
			arrs[min] = temp;
		}
//		// 정렬된 결과 출력
		for (int num : arrs) {
			System.out.print(num + " ");
		}
	}
}