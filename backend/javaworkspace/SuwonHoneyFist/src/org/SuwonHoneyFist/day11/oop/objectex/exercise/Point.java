package org.SuwonHoneyFist.day11.oop.objectex.exercise;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 동일 객체인 경우 true
        if (obj == null || getClass() != obj.getClass()) return false; // null이거나 클래스 타입이 다른 경우 false
        Point point = (Point) obj; // Object를 Point로 캐스팅
        return x == point.x && y == point.y; // x와 y 좌표가 같은지 비교
    }
}
