package org.SuwonHoneyFist.day10.oop.interfaceex;

public class SamsungPhone implements PhoneInterface{

	@Override
	public void PrintLogo() {
		// TODO Auto-generated method stub
		System.out.println("===== SAMSUNG =====");
	}

	@Override
	public void sendCall() {
		// TODO Auto-generated method stub
		System.out.println("===== S-PHONE CALL =====");
		
	}

}
