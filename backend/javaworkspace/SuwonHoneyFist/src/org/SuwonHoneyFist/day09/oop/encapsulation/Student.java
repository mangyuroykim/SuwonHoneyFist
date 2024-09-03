package org.SuwonHoneyFist.day09.oop.encapsulation;

import java.util.Scanner;

public class Student {
	String name;
	int firstScore;
	int secondScore;

	public Student() {

	}

	public Student(String name, int firstScore, int secondScore) {
		this.name = name;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	// setter() 메소드
	public void setName(String name) {
		this.name = name;
	}

	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}

	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}

	// getter() 메소드
	public String getName() {
		return this.name;
	}

	public int getFirstScore() {
		return this.firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public String toString() {
		return this.name + " 학생의 첫번째 점수는 " + this.firstScore + "점, 두번쨰 점수는 " + this.secondScore + "점입니다.";
	}
}
