package org.SuwonHoneyFist.day02.operator;

public class Exam_Unary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 단항 연산자 
		// a++, ++a -> a = a + 1;
		int a1 = 1;
	    System.out.println(++a1);
	    System.out.println(a1++);
	    System.out.println(a1);
	    // 문제1
	    // a가 10, b는 20, c는 30입니다.
	    // a++;
	    // b = (--a) + b;
	    // c = (a++) + (--b);
	    // a,b,c의 값은 얼마일까요?
	    // a = ?, b = ?, c = ?
	    int a = 10;
	    int b = 20;
	    int c = 30;
	    a++;
	    b= (--a) + b;
	    c = (a++) + (--b);
	   
	    System.out.println("a : " + a + ", b : " + b + ", c : " + c);

	    // a = 11; b=29; c = 39;
	    
	    /**2.논리형 변수 flag를 true초기화 하고 다음 연산을 수행하고
	     * 결과값을 확인해보세요
	     * 
	     * 
	     */
	    // 문제2
	    // x는 100, y는 33, z는 0
	    // x--;
	    // z = x-- + --y ;
	    // x = 99 + x++ + x;
	    // y = y-- + y + ++y;
	    // x: ?, y :, z : ?
	    int x = 100;
	    int y = 33;
	    int z = 0;
	    // x = 99+98+99
	    // y = 32 + 31 + 32
	    // z = 99+32;
	    // x = 297, y = 95, z = 131
	    x--;
	    z = x-- + --y ;
	    x = 99 + x++ + x;
	    y = y-- + y + ++y;
	    System.out.println("x : " + x + ", y : " + y +", z: "+ z );
	}
		
}
