package org.SuwonHoneyFist.day04.array.practice;

public class Practice_Array2 {
	public static void main(String[] args) {
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을
		// 반복문을 이용하여 역순으로 배열 인덱스에 넣은 후
		// 그 값을 출력하세요
		int[] arrs = new int[10];
//        int count = 10;
		for (int i = 0, count = 10; i < 10; i++, count--) {
			arrs[i] = count;
//        	count--;  
		}
		for (int i = 0; i < 10; i++) {
			arrs[i] = 10-i;
		}
//        for (int i = 9; i >= 0; i--) {
//            arrs[9 - i] = i + 1;
//        }
        for (int i = 0; i < 10; i++) {
            System.out.print(arrs[i] + " ");
        }
			}
}
