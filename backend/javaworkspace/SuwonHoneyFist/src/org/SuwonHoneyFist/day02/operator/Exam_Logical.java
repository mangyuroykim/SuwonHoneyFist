package org.SuwonHoneyFist.day02.operator;

public class Exam_Logical {
	public static void main(String [] args) {
		논리연산자 예제
		남자이면서 평균평점 4.3이상인 사람 -> and
		컴퓨터공학과 또는 경영학과인 사람  -> or
		boolean result1, result2, result3, result4;
		boolean result2;
		boolean result3;
		boolean result4;
		 AND -> &&, OR -> ||
		int num1 = 50;
		int num2 = 30;
		변수명이 다르거나 변수 선언 안하면 오류남
		result1 = (num1 == num2) && (num1 < num2);
		System.out.println("결과값1 :" + result1);
		AND 연산자는 둘다 동일해야함 둘중에 하나라도 틀리면 false가 나옴
		전자로 비교하면 직렬 연결상태
		result2 = (num1 < num2) || (num1 == num2);
		System.out.println("결과값2 :" + result2);
		둘중에 하나만 트루면 트루가 된다 false가 되는경우는 둘다 연결된경우/
		병렬 연결상태
//		result3 = (num1 > num2) && (num1 != num2);
//		result4 = (num1 > num2) || (num1 == num2);
//		System.out.println("결과값3 :" + result3);
//		System.out.println("결과값4 :" + result4);
		
		//1. 50, 30을 입력 받아 다음과 같은 식을 작성 하였을때 결과값을 예상해보고 출력해보자.
//		int a = 50;
//		int b = 30;
//		result1 = (a!=b) && (a<b);
//		result2 = (a < b) || (a==b);
//		result3 = (a > b) && (a !=b);
//		result4 = (a>b) || (a==b);
//		//result1 = false
//		//result2 = false
//		//result3 = true
//		//result4 = true
//		System.out.println(result1);
//		System.out.println(result2);
//		System.out.println(result3);
//		System.out.println(result4);
		
		//2. 70,55을 a,b로 입력받아 다음과 같은 식을 작성하였을때
//		결과값을 예상해보고 출력해보자.
//		a==b || a++<100
//		a < b && --b < 55
//		a! = b && b-- < a++
//		a++ != b || b++ >=85
//		a=?
//		b=?
//		int a = 70;
//		int b = 55;
//		result1 = (a==b) || (a++<100);
//		result2 = (a < b) && (--b < 55); //and의 경우 앞의 결과가 false면 뒤는 연산 X
//		result3 = (a != b) && (b-- < a++); //or의 경우 앞의 결과가 true면 뒤는 연산 X
		result4 = (a++ != b) || (b++ >=85);
		//result1 = true
		//result2 = false
		//result3 = true
		//result4 = true
		int a = 70;
		int b = 55;
		result1 = (a==b) || (a++<100);
		result2 = (a < b) && (--b < 55); //and의 경우 앞의 결과가 false면 뒤는 연산 X
		result3 = (a != b) && (b-- < a++); //or의 경우 앞의 결과가 true면 뒤는 연산 X
		result4 = (a++ != b) || (b++ >=85);
		System.out.println("a :" + a + ", b : " +b);
		System.out.println("result1 : " + result1 + ", result2 : " + result2
								);
}
