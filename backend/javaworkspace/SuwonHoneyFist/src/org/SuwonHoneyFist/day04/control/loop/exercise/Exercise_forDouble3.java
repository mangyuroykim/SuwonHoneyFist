package org.SuwonHoneyFist.day04.control.loop.exercise;

public class Exercise_forDouble3 {
	public static void main(String[] args) {
		// 2단을 세로로 출력, 그 옆에 3단 세로로 출력,
		// 그 옆에 4단 세로로 출력
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + " * " + i + " = " + j * i);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
//2 * 1 = 2	3 * 1 = 3	4 * 1 = 4	5 * 1 = 5	6 * 1 = 6	7 * 1 = 7	8 * 1 = 8	9 * 1 = 9	
//2 * 2 = 4	3 * 2 = 6	4 * 2 = 8	5 * 2 = 10	6 * 2 = 12	7 * 2 = 14	8 * 2 = 16	9 * 2 = 18	
//2 * 3 = 6	3 * 3 = 9	4 * 3 = 12	5 * 3 = 15	6 * 3 = 18	7 * 3 = 21	8 * 3 = 24	9 * 3 = 27	
//2 * 4 = 8	3 * 4 = 12	4 * 4 = 16	5 * 4 = 20	6 * 4 = 24	7 * 4 = 28	8 * 4 = 32	9 * 4 = 36	
//2 * 5 = 10	3 * 5 = 15	4 * 5 = 20	5 * 5 = 25	6 * 5 = 30	7 * 5 = 35	8 * 5 = 40	9 * 5 = 45	
//2 * 6 = 12	3 * 6 = 18	4 * 6 = 24	5 * 6 = 30	6 * 6 = 36	7 * 6 = 42	8 * 6 = 48	9 * 6 = 54	
//2 * 7 = 14	3 * 7 = 21	4 * 7 = 28	5 * 7 = 35	6 * 7 = 42	7 * 7 = 49	8 * 7 = 56	9 * 7 = 63	
//2 * 8 = 16	3 * 8 = 24	4 * 8 = 32	5 * 8 = 40	6 * 8 = 48	7 * 8 = 56	8 * 8 = 64	9 * 8 = 72	
//2 * 9 = 18	3 * 9 = 27	4 * 9 = 36	5 * 9 = 45	6 * 9 = 54	7 * 9 = 63	8 * 9 = 72	9 * 9 = 81	
//**이렇게 출력되는 이유는 내부 for문에는
//바깥에 변수지정된 i가 초기화값만 반영되고 
//뒤에 조건식이 반영이 안되고 초기화값만 들어가서 글머
//i++등은 바깥쪽 for문에만 적용되는거라
//2 * 1 = 2	3 * 1 = 3	4 * 1 = 4	5 * 1 = 5 이렇게 옆으로 한줄씩
//출력되고 바깥쪽 for문 안에 있는 System.out.println(); 명령으로
//* 9까지 출력하고 한줄씩 띄어서 i++ i <10 (9까지) 출력되는거임//
//그래서 실제로는 옆으로 출력하고 한줄씩 띄워 논거지만
//눈에 보이기에는 세로로 출력된것처럼 보이는거임 착시 착시