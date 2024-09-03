package org.SuwonHoneyFist.day10.polymorphism;

/* 객체지향 원칙
 * 1. 캡슐화
 *  - 클래스의 등장배경
 *  - private
 *  2. 상속
 *   - 내가 가지고 있지 않아도 받아서 쓸 수 있음.
 *   3. 다형성
 *   - 업캐스팅 / 다운 캐스팅
 *   -오버라이딩
 */
class Person {
	String name;
	String id;

	public Person() {
	}

	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
}

class Student extends Person {
	String grade;
	String department;

	public Student() {

	}

	public Student(String grade, String department) {
		this.grade = grade;
		this.department = department;

	}
}

public class Exam_DownCasting {
	public static void main(String[] args) {
		Person p = new Student(); // 업캐스팅
									// 상속관계인 경우에 가능
		System.out.println(p.name);
		System.out.println(p.id);
		
		
		// 다운캐스팅
		System.out.println(((Student)p).grade); // grade cannot be resolved or is not a field
		System.out.println(((Student)p).department); // grade cannot be resolved or is not a field
	}

}
