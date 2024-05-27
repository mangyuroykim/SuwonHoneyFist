package jaseupsigan;

public class jaseupsigan_practice19 {
	public static void main(String [] args) {
        // 0시 0분부터 23시 59분까지 출력하기
		for(int hour = 0; hour < 24; hour++) {
			for(int minute = 0; minute <60; minute ++) {
				System.out.println(hour +"시 " + minute + "분");
			}
		}
	}
}
