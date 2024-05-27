package jaseupsigan;

public class jaseupsigan_practice18 {
	public static void main(String[] args) {
		// *
		// **
		// ***
		// ****
		// *****
		// ****** 를 출력하시오
		for (int j = 1; j < 7; j++) {
			for (int i = 1; i <=j; i++) { // i <=j인 이유는 반복된 출력값은 한번에 나오니까
										//한번 반복하면 한개 두번반복하면 두개 이렇게 나와야되니까 j값을 쓴거
				System.out.print("*");
			}
			System.out.println();	
		}
		
	}
}
