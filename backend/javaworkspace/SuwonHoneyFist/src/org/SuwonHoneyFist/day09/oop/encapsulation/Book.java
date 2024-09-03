package org.SuwonHoneyFist.day09.oop.encapsulation;

public class Book {
	public static void main(String[] args) {
		// 필드에 직접 접근 (옳지 않음)
//		Book book = new Book();
//		book.title = "춘향뎐";		//is not visible
//		book.author = "작자미상";
		
		// 필드에 직접 접근하지 않고 객체 초기화하는 방법
		// 생성자를 통해서 초기화
		Book book = new Book("춘향뎐", "작자미상");
		// setter() 메소드를 이용한 초기화
		Book bookbook = new Book();
		bookbook.setTitle("춘향뎐");
		bookbook.setAuthor("작자미상");
	}
	
		
	private	String title;
	private	String author;
		
	public Book() {
			this("","");
		}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		}
	// 얘네 (setter(), getter()) 왜 쓰는거지?
	// 얘네 왜 쓰는거지? 필드에 직접 접근하지 못하게 하고 우회해서 접근하게 하려고
	// 1. set을 쓰고 필드명을 낙타 표기법으로 써줌
	// ex) 필드가 name이면 setter()메소드는 setName()가 됨
	// 2. get을 쓰고 필드명을 낙타표기법으로 써줌
	// ex) 필드가 age이면 getter() 메소드는 getAge()가 됨.
	// setter() 메소드
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	// getter 메소드
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	// 멤버 필드
	// 이름			bookTitle
	// 가격			bookPrice
	// 저자			bookAuthor
	// 카테고리		category
	// 출판사		publisher
	// 출판날짜		publishingDate
//	String Title;
//	int price;
//	String author;
//	String category;
//	String publisher;
//	String publishingDate;
//	
	// 멤버 메소드
	// 빌려주다, 팔리다, 입고되다(등록), ...
}
