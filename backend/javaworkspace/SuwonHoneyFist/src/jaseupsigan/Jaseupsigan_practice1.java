package jaseupsigan;

import java.util.Scanner;

public class Jaseupsigan_practice1 {
	public static void main(String [] args) {
//		예제1. 입력받은 정수가 짝수인지 홀수인지 판별하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		System.out.println("정수값을 입력하세요.");
		int input = sc.nextInt();
//		if (input % 2 == 0)  {
//			System.out.println("짝수 입니다.");
//		}else {
//			System.out.println("홀수 입니다.");
//		}
		String result = (input % 2 == 0) ? "짝수" : "홀수";
		System.out.println(result + " 입니다.");
		
		
	}
	

}
