package jaseupsigan;

public class jaseupsigan_practice22 {
	public static void main(String[] args) {
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을
		// 반복문을 이용하여 역순으로 배열 인덱스에 넣은 후
		// 그 값을 출력하세요
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) { // 배열 안에 "숫자"넣는중
			arr[i] = 10 - i;
			System.out.print(arr[i] + " ");
		}
//원래 for문 두번쓴건데 (이중 for문 아님) for 조건식이 같아서 하나로 묶은거.
		
	}

}
