package jaseupsigan;

import java.util.Scanner;

public class jaseupsigan_practice6 {
	public static void main(String[] args) {
		// 커피메뉴를 입력받고 가격을 알려주는 프로그램을 작성하시오
		// 주문하시겠어요? 가격을 알려드립니다.
		// (에스프레소, 카푸치노, 카페라떼, 아메리카노)
		// 메뉴를 입력해주세요 : 에스프레소
		// 2500원입니다.
		// 메뉴를 입력해주세요 : 자바칩 프라프치노
		// 없는 메뉴입니다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("주문하시겠어요? 가격을 알려드립니다.");
		System.out.println("에스프레소, 카푸치노, 카페라떼, 아메리카노");
		System.out.print("메뉴를 입력해주세요 : ");
		String menu = scanner.next();
		int price = 0;
		switch(menu) {
		case("에스프레소") :
			price = 3500;		
		case("카푸치노") :
			price = 4300;		
		case("카페라떼") :
			price = 4500;		
		case("아메리카노") :
			price = 1500;		
		if(price !=0) {
			System.out.println(price +"원입니다.");
				}
		}
		
	}
}
