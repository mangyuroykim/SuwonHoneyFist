package jaseupsigan;

import java.util.Scanner;

public class jaseupsigan_practice5 {
	public static void main(String [] args) {
		//점수를 입력받아 등급을 알려주는 프로그램을 작성하세요
		//점수를 입력해주세요 : 92
		//학점은 A입니다.
		//단, 점수는 0 ~100 사이의 수를 입력하도록 함.
		//점수를 입력해주세요 : 102
		// 0 ~ 100사이의 수를 입력해주세요
		//커트라인 ( 90 ~ 100 : A, 89 ~ 80 : B, 79 ~70 : C, 69 ~ 60 : D, 그 외 F
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력해주세요 :");
		int score = sc.nextInt();
		if (score > 100) {
			System.out.print("0 ~ 100사이의 수를 입력해주세요");
		} else if (score >=90 && score <= 100) {
			System.out.print("학점은 " + "A" + "입니다.");
		} else if (score >=80 && score <= 89) {
			System.out.print("학점은 " + "B" + "입니다.");
		} else if (score >=70 && score <= 79) {
			System.out.print("학점은 " + "C" + "입니다.");
		} else if (score >=60 && score <= 69) {
			System.out.print("학점은 " + "D" + "입니다.");
		} else {
			System.out.print("학점은 F입니다");
		}
	}
}
