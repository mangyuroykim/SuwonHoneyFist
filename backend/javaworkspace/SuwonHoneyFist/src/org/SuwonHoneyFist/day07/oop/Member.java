package org.SuwonHoneyFist.day07.oop;

import java.util.Scanner;

public class Member {
	// 멤버 변수(필드)
	public String name;
	char gender;
	public int age;
	String education;
	long salary;
	public String job;
	String property; //집1채, 자동차2대 / 500000000
	String phone; // 01012342345   <-숫자로하면 맨앞에 0은 저장을 안하기 때문
	String address;
	boolean divorceYN; // Yes or No 
	String children; // 1남 1여, 아들1, 딸1
	//            *기본형들은 클래스가 아님*
	public Member() {} //생성자
	
	// 멤버 메소드 (메소드)
	public void registerMember() {}
	public void doHeart() {}
	public void sendMessage () {}
	public void doPromise() {}
}
