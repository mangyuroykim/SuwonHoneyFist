package org.SuwonHoneyFist.day02.printbasic;

public class Exam_PrintSample {
	public static void main(String [] args) {
		System.out.println("이것이 원래 쓰던거");
		System.out.print("이게 조금 다른거 \n"); //개행이 없어서 \n
		//형식 문자
		//1. 정수 : %d
		//2. 실수 : %f
		//3. 문자 : %c
		//4. 문자열 : %s
		System.out.printf("정수 출력 : %d, 문자열 출력 : %S", 1023, "일공이삼");
		System.out.println("이제 끝~!");
		System.out.printf("개강날짜 : %.1f, 종강 날짜 : %.2f\n", 5.7, 10.23 );
		//%f에서 %뒤에 .2 적으면 소수점 둘째자리까지 표현
	}
}
