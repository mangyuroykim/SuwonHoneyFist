package jaseupsigan;

public class jaseupsigan_practice20 {
	public static void main(String[] args) {
		// 2단을 세로로 출력, 그 옆에 3단 세로로 출력,
		// 그 옆에 4단 세로로 출력
		for (int dan = 1; dan < 10; dan++) {
			for (int dan2 = 2; dan2 < 5; dan2++) {
				System.out.print(dan2 + " * " + dan + " = " + dan * dan2);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
