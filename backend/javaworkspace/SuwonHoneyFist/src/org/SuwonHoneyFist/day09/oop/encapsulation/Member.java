package org.SuwonHoneyFist.day09.oop.encapsulation;

import java.util.Scanner;

public class Member {
	// 멤버 변수(필드)
	private public String name;
	private char gender;
	private int age;
	private String education;
	private long salary;
	private String job;
	private String property; //집1채, 자동차2대 / 500000000
	private String phone; // 01012342345   <-숫자로하면 맨앞에 0은 저장을 안하기 때문
	private String address;
	private boolean divorceYN; // Yes or No 
	private String children; // 1남 1여, 아들1, 딸1
	//            *기본형들은 클래스가 아님*
	public Member() {} //생성자
	
	// 멤버 메소드 (메소드)
	public void registerMember() {}
	public void doHeart() {}
	public void sendMessage () {}
	public void doPromise() {}
}
