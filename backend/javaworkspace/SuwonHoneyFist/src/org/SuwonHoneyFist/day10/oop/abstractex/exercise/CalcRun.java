package org.SuwonHoneyFist.day10.oop.abstractex.exercise;

public class CalcRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new GoodCalc();
		//		GoodCalc calc = new GoodCalc();
		int i = calc.add(5, 7);
		System.out.println("합 : " + i); // 5 7
		int j = calc.substract(10, 23);
		System.out.println("차 : " + j); // 10 23
		int [] k = { 57, 1023};
		double avg = calc.average(k);  
		System.out.println("평균 : " + avg); // 57 1023
//		
		System.out.println("합 : " + calc.add(5, 7));
		System.out.println("차 : " + calc.substract(10, 23));
		System.out.println("평균 : " + calc.average(k));
		
	}

}
