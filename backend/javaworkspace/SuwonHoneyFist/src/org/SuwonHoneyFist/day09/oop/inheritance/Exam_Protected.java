package org.SuwonHoneyFist.day09.oop.inheritance;

import org.SuwonHoneyFist.day09.oop.inheritance.point.Point;

class Super {
	
	public int pub;
	int def; //default
	protected int pro;
	private int pri;
	
	
}
class Sub extends Super{
	void set() {
		super.pub = 24;
		super.def = 5;
		super.pro = 7;
//		super.pri = 1023; // is not visible;
	}
}
class ShapePoint extends point{
	void set() {
		Point p = new Point();
		p.pub = 24; // public 이니까
//		p.def = 57; // default는 같은 패키지에서만 가능
//		p.pro = 10; // protected는 같은 패키지 또는 상속일 때 가능
		super.pub = 2024;
//		super.def = 507;
		super.pro = 23;
//		super.pri = 1023;
		//		p.pri = 23; // 당연히 안됨 private
	}
}
public class Exam_Protected {

}
