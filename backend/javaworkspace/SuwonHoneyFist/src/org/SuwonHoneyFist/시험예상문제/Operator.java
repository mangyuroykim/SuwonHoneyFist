package org.SuwonHoneyFist.시험예상문제;


import java.util.Scanner;

/* 두 정수를 입력받아 합계를 출력하는 코드를 작성하였다. 입력 시 정수가 아닌 경우 메시지 출력 후
 * 다시 입력 받을 수 있도록 반복문과 예외처리까지 작성하였다.
 * 그러나 Runtime시 잘못입력된 경우 작동에 문제가 발생하였다. 소스코드를 분석하여 원인(문제점+사유), 조치내용(해결 방법)을 작성하시오.
 *  
 */
class Operator {
	public void plus() {
		int[] num = new int[2];
		for (int i = 0; i < num.length; i++) {
			num[i] = inputNumber(i);
		}
		System.out.println("두 수의 합은 : " + (num[0] + num[1]));
	}

	public int inputNumber(int i) {
		Scanner sc = new Scanner(System.in);
		int inputNumber;
		while (true) {
			try {
				System.out.println((i + 1) + "번째 정수를 입력하세요 : ");
				inputNumber = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다. 정수만 입력해주세요");
				sc.next();
			}
		}
		return inputNumber;
	}
}
public class OperatorRun{
	public static void main(String[] args) {
		new Operator().plus();
	}
}

