package org.SuwonHoneyFist.day03.loop.exercise;

public class Exercise_while1 {
	public static void main(String[] args) {
		// while문을 이용하여 1 ~ 100사이의 홀수의 합을 출력하시오
		// 1 ! 100 사이의 합 홀수의 합 : ?
		int i = 1;
		int sum = 0;
		while (i <= 100) {
			if (i % 2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
	}
}
