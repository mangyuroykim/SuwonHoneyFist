package org.SuwonHoneyFist.day07.oop.run;

import java.util.Scanner;

import org.SuwonHoneyFist.day07.oop.Book;
import org.SuwonHoneyFist.day07.oop.Circle;
import org.SuwonHoneyFist.day07.oop.Member;
import org.SuwonHoneyFist.day07.oop.exercise.Rectangle;

//public class Run {
	public static void main (String[] args) {
		ex.oppPractice1();
		Run ex = new Run();
		Run.oopPractice1();
		this.oopExercise();
		Math.random();
	}

	public static void main(String[] args) {

		// 생성자 예제 연습
//		Book book = new Book(); // 기본 생성자 이용해서 객체 생성
		// title, author는 모두 비어있음
//		book.title = "춘향뎐";
//		book.author = "작자미상";
		Book book = new Book("춘향뎐", "작자미상");
		Book emptyBook = new Book();

		Circle bintz = new Circle();
		bintz.setRadius(10);

		// 문제 1: 너비와 높이를 입력받아 사각형의 넓이를 출력하는 클래스
		System.out.print("너비: ");
		int width = sc.nextInt();
		System.out.print("높이: ");
		int height = sc.nextInt();

		Rectangle rect = new Rectangle();
		rect.width = width;
		rect.height = height;

		int result = rect.getArea();
		System.out.println("사각형의 넓이는 " + result + "입니다.");

	}

	public static void oopExercise() {

		// 예제 1: Circle의 인스턴스를 이용하여 이름이 달덩이, 반지름은 5인 Circle의 넓이 출력
		Circle circle = new Circle();
		circle.radius = 5.0;
		circle.name = "달덩이";
		double circleArea = circle.getArea();
		System.out.println("원의 이름: " + circle.name);
		System.out.println("원의 반지름: " + circle.radius);
		System.out.println("원의 넓이: " + circleArea);

		// 또 다른 Circle 예제
		Circle dounut = new Circle();
		dounut.radius = 2;
		dounut.name = "던킨도넛";
		double dounutArea = dounut.getArea();
		System.out.println("원의 이름: " + dounut.name);
		System.out.println("원의 반지름: " + dounut.radius);
		System.out.println("원의 넓이: " + dounutArea);

	}

	public void memberPractice() {
		// Member 클래스 예제
		Scanner sc = new Scanner(System.in);
		Member member1 = new Member();
		member1.name = "일용자";
		member1.age = 33;
		member1.job = "의사";

		Member member2 = new Member();
		member2.name = "이용자";
		member2.age = 22;

		System.out.println("이름: " + member1.name);
		System.out.println("직업: " + member1.job);
		System.out.println("나이: " + member1.age);

		System.out.println("이름: " + member2.name);
		System.out.println("직업: " + member2.job); // 직업이 설정되지 않았음
		System.out.println("나이: " + member2.age);

		sc.close();
	}
}