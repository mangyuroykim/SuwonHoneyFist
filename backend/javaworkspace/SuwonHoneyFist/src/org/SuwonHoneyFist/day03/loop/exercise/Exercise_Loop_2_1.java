import java.util.Scanner;

public class Exercise_Loop_2_1 {
    public static void main(String[] args) {
    	// 1번
        // 1부터 사용자에게 입력 받은 수까지 중에서
        // 1) 2와 3의 배수를 모두 출력하고
        // 2) 2와 3의 공배수의 개수를 출력하세요.
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");
        int num = sc.nextInt();
        int count = 0;
        System.out.print("2와 3의 배수 : ");
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                System.out.print(i + " ");
                if (i % 2 == 0 && i % 3 == 0) {
                    count++;
                }
            }
        }
        System.out.println("\n2와 3의 공배수의 개수: " + count);
    }
}
