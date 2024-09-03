package org.SuwonHoneyFist.day05.dimarray.exercise;

import java.util.Scanner;

public class Run {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Exercise_DimArray exercise = new Exercise_DimArray();
        
        while (true) {
            System.out.println("선택하세요: ");
            System.out.println("1: 이차원 배열 랜덤 소문자 입력");
            System.out.println("2: 숫자 배열 오른쪽에서 왼쪽 출력");
            System.out.println("3: 숫자 배열 세로 방향으로 증가 출력");
            System.out.println("4: 숫자 배열 세로 방향으로 증가 출력 (변형)");
            System.out.println("5: 숫자 배열 지그재그 출력");
            System.out.println("0: 종료");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    exercise.practiceDimArray1();
                    break;
                case 2:
                    exercise.practiceDimArray2();
                    break;
                case 3:
                    exercise.practiceDimArray3();
                    break;
                case 4:
                    exercise.practiceDimArray4();
                    break;
                case 5:
                    exercise.practiceDimArray5();
                    break;
                case 0:
                    sc.close();
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }
}
