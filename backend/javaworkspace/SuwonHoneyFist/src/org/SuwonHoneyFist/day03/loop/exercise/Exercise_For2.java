package org.SuwonHoneyFist.day03.loop.exercise;

import java.util.Scanner;

public class Exercise_For2 {
	public static void main(String[] args) {
		// 1부터 10까지의 덧셈을 표시하고 합도 구하시오.
		// 1+2+3+4+5+6+7+8+9+10=55
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			sum += i;
			System.out.print(i + "+");
			if (i == 10)
				System.out.print(i + "=");
		}

//	System.out.println("1+2+3+4+5+6+7+8+9 = " + sum);
		System.out.println(sum);
	}
}
