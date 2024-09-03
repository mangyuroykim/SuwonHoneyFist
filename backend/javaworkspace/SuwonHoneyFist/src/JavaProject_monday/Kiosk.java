package JavaProject_monday;

import java.util.Scanner;

public class Kiosk {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		selectMainMenu(sc);
	}

	public static void selectMainMenu(Scanner sc) {
		System.out.println("    ◆◇◆◇ OO랜드의 오신걸 환영합니다 ◆◇◆◇");
		System.out.println("◆◇◆◇ 원하시는 메뉴의 번호를 선택해주세요 ◆◇◆◇\n");
		System.out.println("1.츄러스");
		System.out.println("2.음료");
		int i = sc.nextInt();

		switch (i) {
		case 1:
			selectChurrosMenu(sc);
			break;
		case 2:
			selectDrinkMenu(sc);
			break;
		default:
			System.out.println("◆◇◆◇ 잘못된 입력입니다 다시 선택해주세요 ◆◇◆◇");
			selectMainMenu(sc);
		}
	}

	public static void selectChurrosMenu(Scanner sc) {
		System.out.println("◆◇◆◇ 원하시는 츄러스의 번호를 선택해주세요 ◆◇◆◇\n");
		System.out.println("1.기본 츄러스");
		System.out.println("2.시나몬 츄러스");
		System.out.println("3.초코 츄러스");
		System.out.println("4.취소");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("        ◆◇◆◇ 기본 츄러스를 선택하셨습니다 ◆◇◆◇");
			selectPaymentMenu(sc); 
			break;
		case 2:
			System.out.println("        ◆◇◆◇ 시나몬 츄러스를 선택하셨습니다 ◆◇◆◇");
			selectPaymentMenu(sc); 
			break;
		case 3:
			System.out.println("        ◆◇◆◇ 초코 츄러스를 선택하셨습니다 ◆◇◆◇");
			selectPaymentMenu(sc); 
			break;
		case 4:
			System.out.println("        ◆◇◆◇ 취소 되었습니다 ◆◇◆◇\n");
			selectMainMenu(sc); // 초기 메뉴 선택으로 이동
			break;
		default:
			System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			selectChurrosMenu(sc);
		}
	}

	public static void selectDrinkMenu(Scanner sc) {
		System.out.println("◆◇◆◇원하시는 음료의 번호를 선택해주세요◆◇◆◇\n");
		System.out.println("1.아메리카노");
		System.out.println("2.아이스티");
		System.out.println("3.취소");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("        ◆◇◆◇ 아메리카노를 선택하셨습니다 ◆◇◆◇");
			selectPaymentMenu(sc);
			break;
		case 2:
			System.out.println("        ◆◇◆◇ 아이스티를 선택하셨습니다 ◆◇◆◇");
			selectPaymentMenu(sc);
			break;
		case 3:
			System.out.println("        ◆◇◆◇ 취소 되었습니다 ◆◇◆◇\n");
			selectMainMenu(sc);
			break;
		default:
			System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			selectDrinkMenu(sc);
		}
	}

	public static void paymentMenu(Scanner sc) {
		System.out.println("             ◆◇◆◇ 결제 수단을 선택하세요 ◆◇◆◇\n");
		System.out.println("1.카드");
		System.out.println("2.현금");
		System.out.println("3.취소");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("  ◆◇◆◇ 현재 키오스크 점검 중 입니다 ◆◇◆◇\n   ◆◇◆◇ 직원에게 결제문의 바랍니다 ◆◇◆◇");
			System.out.println("               ");
			selectMainMenu(sc);

			break;
		case 2:
			System.out.println("  ◆◇◆◇ 현금 결제는 직원에게 직접 결제 바랍니다 ◆◇◆◇");
			System.out.println("               ");
			selectMainMenu(sc); 
			break;
		case 3:
			System.out.println("        ◆◇◆◇ 취소 되었습니다 ◆◇◆◇\n");
			selectMainMenu(sc); 
			break;
		default:
			System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			selectPaymentMenu(sc);
		
		}
		
	}

	public static void selectPaymentMenu(Scanner sc) {
		System.out.println("             ◆◇◆◇ 결제 하시겠습니까? ◆◇◆◇\n");
		System.out.println("1.결제하기");
		System.out.println("2.취소");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			paymentMenu(sc);
			break;
		case 2:
			System.out.println("        ◆◇◆◇ 취소 되었습니다 ◆◇◆◇\n");
			selectMainMenu(sc); 
			break;
		default:
			System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			selectPaymentMenu(sc);
		}

	}
}
