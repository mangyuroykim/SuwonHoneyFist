package org.SuwonHoneyFist.day08.oop.objectarray;

import java.util.Scanner;

public class ObjectArray2 {
	public static void main(String[] args) {
//		여러개의 책이 존재하는데 그 책의 정보를 저장하려함
//		책은 3권까지 저장할 수 있도록 하고 제목과 저자만 받을 수 있고
//		프로그램을 작성하시오
//		
		Book [] books = new Book[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i< books.length; i++) {
			System.out.print(">> ");
			String title = sc.nextLine();
			System.out.print(">> ");
			String author = sc.nextLine();
			books[i] = new Book(title, author);
			
		}
		
		for(Book book : books) {
			System.out.println(book.toString());
		}
		
		
	}
	
	
	
	
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Book[] books = new Book[3]; 
//        int count = 0; 
//
//        while (true) {
//            System.out.println("메뉴를 선택하세요:");
//            System.out.println("1. 책 정보 입력");
//            System.out.println("2. 책 정보 출력");
//            System.out.println("3. 종료");
//            System.out.print("선택 >> ");
//            int choice = sc.nextInt();
//
//            switch (choice) {
//                case 1:
//                    if (count < 4) {
//                        Book book = new Book();
//                        book.inputBookInfo(sc);
//                        books[count] = book;
//                        count++;
//                    } else {
//                        System.out.println("더 이상 책을 저장할 수 없습니다.");
//                    }
//                    break;
//                case 2:
//                    for (int i = 0; i < count; i++) {
//                        System.out.println(books[i]);
//                    }
//                    break;
//                case 3:
//                    System.out.println("프로그램을 종료합니다.");
//                    sc.close();
//                    return;
//                default:
//                    System.out.println("1 ~ 3 사이의 수를 입력해주세요.");
//            }
//        }
    
}
