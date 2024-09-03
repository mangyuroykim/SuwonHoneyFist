package org.SuwonHoneyFist.day08.oop.objectarray.student;

public class Student {
    private String name;
    private int firstScore;
    private int secondScore;

    public Student(String name, int firstScore, int secondScore) {
        this.name = name;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public String getName() {
        return name;
    }

    public int getFirstScore() {
        return firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }

    public String toString() {
        return name + " 학생의 첫번째 점수는 " + firstScore + "점, 두번째 점수는 " + secondScore + "점입니다.";
    }
}
