package org.SuwonHoneyFist.day05.exception.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_Exception2 {
	public static void main(String[] args) {
		// 문제 2
		// 3개의 정수를 입력받아 합을 구하는 프로그램을 작성하여라
		// 사용자가 정수가 아닌 문자를 입력할 때 발생하는
		// InputMismatchException 예외를 처리하여 다시 입력받도록
		// 정수 3개를 입력하세요.
		// 11 2 3
		// 합은 16
		int num = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
	      for (int i = 1; i <= 3; i++) {
	            while (true) {
	                try {
	                    System.out.printf("%d번째 정수 입력: ", i);
	                    num = sc.nextInt();
	                    sum += num;
	                    break;
	                } catch (InputMismatchException e) {
	                    System.out.println("유효한 정수를 입력하세요.");
	                    sc.next(); 
	                }
	            }
	        }

	        System.out.printf("3개의 정수의 합은 %d입니다.\n", sum);
	}
}
