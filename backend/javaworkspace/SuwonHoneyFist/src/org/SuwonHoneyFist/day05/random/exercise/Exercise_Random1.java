package org.SuwonHoneyFist.day05.random.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Random1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Random rand = new Random();
		while (true) {
			System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");
			int choice = sc.nextInt();
//			int coinResult = rand.nextInt(2) + 1; // 1 또는 2 (앞면 또는 뒷면)
			int coinResult = (int)(Math.random()*2)+1;
			System.out.println(coinResult);
			if(choice == -1) break;
			if (choice == coinResult) {
				System.out.println("맞췄습니다.");
			} else {
				System.out.println("틀렸습니다. 동전은 " + (coinResult == 1 ? "앞면" : "뒷면") + "입니다.");
			}

		}

	}
}