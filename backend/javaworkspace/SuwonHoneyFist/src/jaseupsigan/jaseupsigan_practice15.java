package jaseupsigan;

import java.util.Scanner;

public class jaseupsigan_practice15 {
	public static void main(String [] args) {
        // 4번
        // 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
        // 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		int num = scanner.nextInt();
		System.out.print("숫자를 입력해주세요 : ");
		int num2 = scanner.nextInt();
		if(num < 1 || num2 < 1 ) {
			System.out.print("1 이상의 숫자를 입력해주세요");
		}else {
			for(int i = num; i <= num2; i++) {
			 	System.out.print(i + " ");
			}
		}
	}
}

/** if (num1 < 1 || num2 < 1) {
System.out.print("1 이상의 숫자를 입력해주세요");
} else {
if (num1 < num2) {
    start = num1;
    end = num2;
} else {
    start = num2;
    end = num1;
}

for (int i = start; i <= end; i++) {
    System.out.print(i + " ");// num1과 num2에 자유롭게 높은값을 입력하고 싶을경우 start와 end를 if와 else에 바꿔서 입력한다.