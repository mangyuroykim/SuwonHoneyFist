package jaseupsigan;

import java.util.Scanner;

public class jaseupsigan_practice11 {
	public static void main(String[] args) {
		// while문을 이용하여 -1이 입력될때까지
		// 정수를 입력 받고
		// -1이 입력되면 입력한 수의 합을 출력하시오.
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 값을 입력하세요 : ");
		int i = scanner.nextInt();
		int sum = 0;
		while( i != -1) {
			System.out.print("정수 값을 입력하세요 : ");
			i = scanner.nextInt();
			sum += i;
			if( i ==-1) {
				System.out.print(sum);
			}
		}
	}
}
