package jaseupsigan;

import java.util.Scanner;

public class jaseupsigan_practice8 {
	public static void main(String[] args) {
		// 정수 하나를 입력받아서 그 수가 1 ~9 사이의 수일 때만
		// 그 수의 구구단을 출력하세요.
		// 단, 조건이 맞지 않으면 "1 ~9 사이의 양수를 입력하여야 합니다"를
		// 출력하세요.
		Scanner scanner = new Scanner(System.in);
		System.out.print("구구단 출력을 위해 정수를 하나만 입력하세요 : ");
		int dan = scanner.nextInt();
		
			if(dan < 1 || dan >10) {
				System.out.print("1 ~ 9 사이의 양수를 입력하여야 합니다.");
			} else {
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}

		
	}
}
}