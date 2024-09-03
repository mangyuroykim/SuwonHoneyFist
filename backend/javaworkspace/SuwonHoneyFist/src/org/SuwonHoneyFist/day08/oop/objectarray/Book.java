package org.SuwonHoneyFist.day08.oop.objectarray;

import java.util.Scanner;

public class Book {
	// 제목
	// 저자
	public String title;
	public String author;
	
	public Book() {}
	
	public Book(String title, String author)
		this.title = title;
		this.author = author;
}
public String toString() {
		return "("+this.title+","+this.author+")";
}
}


//
//    private String title;
//    private String author;
//
//    public Book() {}
//
//    public Book(String title, String author) {
//        this.title = title;
//        this.author = author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//
//    public void inputBookInfo(Scanner sc) {
//        System.out.print("책의 제목을 입력하세요 : ");
//        this.title = sc.next();
//        System.out.print("책의 저자를 입력하세요 : ");
//        this.author = sc.next();
//    }
//
//
//    public String toString() {
//        return "(" + title + ", " + author + ")";
//   
//
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//
//    public void setTitle(String title) {
//        this.title = title;
//    } }
//}
