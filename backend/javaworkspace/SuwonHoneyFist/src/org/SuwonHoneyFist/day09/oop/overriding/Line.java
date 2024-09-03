package org.SuwonHoneyFist.day09.oop.overriding;

public class Line extends Shape  {
	//@override // 어노테이션 생략 가능
		public void draw() {
			System.out.println("Line");
		}
}
