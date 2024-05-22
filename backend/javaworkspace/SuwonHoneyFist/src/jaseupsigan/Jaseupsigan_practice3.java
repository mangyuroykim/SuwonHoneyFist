package jaseupsigan;

import java.util.Scanner;

public class Jaseupsigan_practice3 {
	public static void main(String [] args) {
		//문제1
				//점수와 학년을 정수로 입력받아 60점 이상이면 합격
				// 60점 미만이면 불합격으로 출력한다.
				//단, 4학년의 경우 70점 이상이어야 합격을 출력하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		System.out.println("학년을 입력하세요");
		int grade = sc.nextInt();
		if (score < 60) {
			System.out.println("불합격");
					
		} else if(grade == 4 && score >= 70) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}
	

}
