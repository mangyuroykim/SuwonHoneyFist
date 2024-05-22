package org.SuwonHoneyFist.day02.operator;

public class Exam_Comparison {
	public static void main(String [] args) {
		//비교 연산자
		//더이상 =인 이꼬르가 아니다.
		//이꼬르는 ==다
		//=은 대입연산자이다!!
		int num1 = 50;
		int num2 = 30;
		boolean result1,result2,result3,result4;
		result1 = (num1 > num2);
		result2 = (num1 < num2);
		result3 = (num1 == num2); // 값이 같을 때 true
		result4 = (num1 != num2); // 값이 다를 때 true
		System.out.println("result : " + result1);
		System.out.println("result : " + result2);
		System.out.println("result : " + result3);
		System.out.println("result : " + result4);
	}

}
