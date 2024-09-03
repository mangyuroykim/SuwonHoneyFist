package org.SuwonHoneyFist.day10.oop.abstractex;

abstract class Line extends Shape {
	@Override
	public void draw() {
		
	}
}
// 추상 클래스
// 그냥 클래스
public abstract class Shape {
		String name; 
	
	public Shape() {}
	
	public void paint() {} // 일반 메소드
	public abstract void draw();	// 추상 메소드, 있으면 반드시 추상 클래스
									// only be defined by an abstract class
}