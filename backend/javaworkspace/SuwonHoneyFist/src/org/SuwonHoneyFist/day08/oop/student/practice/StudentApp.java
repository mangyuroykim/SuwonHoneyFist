package org.SuwonHoneyFist.day08.oop.student.practice;

import java.util.Scanner;
import org.SuwonHoneyFist.day08.oop.objectarray.student.ManageStudent;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageStudent manageStudent = new ManageStudent();
        boolean running = true;

        while (running) {
            System.out.println("====== 메인메뉴 ======");
            System.out.println("1. 성적입력");
            System.out.println("2. 성적출력");
            System.out.println("3. 종료");
            System.out.print("선택 : ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("이름 : ");
                    String name = scanner.nextLine();
                    System.out.print("첫번째 점수 : ");
                    int firstScore = scanner.nextInt();
                    System.out.print("두번째 점수 : ");
                    int secondScore = scanner.nextInt();
                    scanner.nextLine(); 

                    manageStudent.addStudent(name, firstScore, secondScore);
                    break;

                case 2:
                    manageStudent.printAllStudents();
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }


    }
}
