package jaseupsigan;

import java.util.Scanner;

public class jaseupsigan_practice4 {
	public static void main(String [] args) {
		//커피메뉴를 입력받고 가격을 알려주는 프로그램을 작성하시오
				//주문하시겠어요? 가격을 알려드립니다.
				// (에스프레소, 카푸치노, 카페라떼, 아메리카노)
				//메뉴를 입력해주세요 : 에스프레소
				//2500원입니다.
				//메뉴를 입력해주세요 : 자바칩 프라프치노
				// 없는 메뉴입니다.
				
//				Scanner scanner = new Scanner(System.in);
//				String result = "에스프레소, 카푸치노, 카페라떼, 아메리카노" ;
//				System.out.println("주문하시겠어요? 가격을 알려드립니다.");
//				System.out.println("(에스프레소, 카푸치노, 카페라떼, 아메리카노)");
//				System.out.println("메뉴를 입력해주세요 : "+ result);
//				String inputString = scanner.nextLine();
		Scanner sc = new Scanner(System.in);
		System.out.println("주문하시겠어요? 가격을 알려드립니다.");
		System.out.println("에스프레소, 카푸치노, 카페라떼, 아메리카노");
		System.out.print("메뉴를 입력해주세요 :");
		String input = sc.next();
		if(input.equals("에스프레소")) {
			System.out.print("3500원 입니다.");
		}
		if(input.equals("카푸치노")) {
			System.out.print("4500원 입니다.");
		}
		if(input.equals("카페라떼")) {
			System.out.print("4300원 입니다.");
		}
		if(input.equals("아메리카노")) {
			System.out.print("1800원 입니다.");
		}
		

		}
	

}
