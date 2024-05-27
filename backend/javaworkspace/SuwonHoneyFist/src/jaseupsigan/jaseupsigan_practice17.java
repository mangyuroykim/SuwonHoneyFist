package jaseupsigan;

import java.util.Scanner;

public class jaseupsigan_practice17 {
	public static void main(String [] args) {
		// 배열의 length 필드를 이용하여 배열 크기만큼 정수를
				// 입력받고 평균을 구하는 프로그램을 작성하라.
				// 단, 배열의 크기는 5이다.
				// 정수 입력 : 24
				// 정수 입력 : 10
				// 정수 입력 : 23
				// 정수 입력 : 5
				// 정수 입력 : 7
				// 평균 :
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[5];
		int sum = 0;
		for(int i = 0; i < 5; i++ ) { // 0부터니까 5까지 해야 4까지 입력됨
			System.out.print("숫자를 입력하세요 : ");
			int num = sc.nextInt();
			sum += num;
			
		}
		System.out.print("평균값은 " + sum/arr.length + " 입니다.");
	//만약에 평균이 소숫점이 나오면 int sum 자리를 double sum으로 바꾸면 됨
	}
	
}
