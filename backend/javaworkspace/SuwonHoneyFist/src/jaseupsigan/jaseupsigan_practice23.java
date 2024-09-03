package jaseupsigan;

import java.util.Scanner;

public class jaseupsigan_practice23 {
	public static void main(String [] args) {
		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
		// 1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if(num < 1) {
			System.out.print("양의 정수를 입력하세요");
		}else {
			int[] arr = new int[num];
			for(int i = 0; i < num; i++ ) {
				arr[i] = i+1;
				System.out.print(arr[i]+" ");
			}
		}
	}
}
		//인덱스는 "0"부터시작이니까 조건이 "양수"이기때문에 
		//0은 양수가 아니니까 num까지가 아니라 num보다 작아야됨
		
		