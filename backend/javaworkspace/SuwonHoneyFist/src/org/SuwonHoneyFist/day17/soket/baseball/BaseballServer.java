package org.SuwonHoneyFist.day17.soket.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BaseballServer {
	public static void main(String[] args) {
		// 서버 소켓을 생성하였습니다.
		// 클라이언트의 접속을 기다립니다.
		// 클라이언트가 접속했습니다.
		// 1 4 5
		// 서버 준비 완료
		// 받기 : 2 3 6
		// 받기 : 1 3 6
		// 받기 : 1 4 6
		// 받기 : 6 4 1
		// 받기 : 5 1 4
		// 받기 : 1 4 5
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 8989;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("서버소켓을 생성하였습니다.");
			Thread.sleep(1500);
			System.out.println("클라이언트의 접속을 기다립니다.");
			socket = serverSocket.accept();
			int [] numbers = new int[3];
			for(int i = 0; i < numbers.length; i++) {
				// 중복없이 3개 숫자이고 1 ~ 9 사이의 수
				// 0.0 ~ 1.0 미만의 랜덤한 실수
				// Math.random() * (최댓값 - 최솟값 + 1 ) + 최솟값
				numbers[i] = (int)(Math.random() * 9) + 1;
				for(int j = 0; j < i;  j++) {
					if(numbers[i] == numbers[j]) {
						// 1 1 
						// i = 1;
						i--;
						// i = 0;
						break;
					}
				}
				
			}	// 출력을 바깥으로
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println("\n서버 준비완료");
			System.out.println("클라이언트가 접속했습니다.");
			// 입출력 스트림 준비
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			String recvMsg = dis.readUTF();
			String [] inputNums = recvMsg.split(" ");
//			System.out.println("받기 : " + recvMsg);
			// 스트라이크 & 볼 판단 로직
			//	1 4 5
			int strike = 0;
			int ball = 0;
			for(int i = 0; i < numbers.length; i++) {
				for(int j = 0 ; j < numbers.length; j ++) {
					int num = Integer.parseInt(inputNums[j]);
					if(numbers[i] == num) {
						if(i == j) {
							
							strike++;
						}else {
							ball++;
						}
						break;
					}
				}
			}
			String result = strike +" 스트라이크 " + ball + " 볼";
			dos.writeUTF(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
