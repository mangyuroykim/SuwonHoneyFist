package org.SuwonHoneyFist.day09.oop.inheritance.point;

public class ColorPoint extends Point {
    private String color;

    public ColorPoint() {
        super(); // 부모 클래스의 기본 생성자를 호출합니다.
    }

    public ColorPoint(int x, int y, String color) {
        super(x, y); // 부모 클래스의 생성자 Point(int x, int y)를 호출합니다.
        this.color = color;
    }

    public void showColorPoint() {
        super.showPoint(); // 부모 클래스의 showPoint() 메서드를 호출합니다.
        System.out.println(this.color + " 색의 점입니다.");
    }
}
