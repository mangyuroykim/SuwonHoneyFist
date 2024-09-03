package org.SuwonHoneyFist.day16.soket.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 9999;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("연결을 기다리고 있습니다..");
			socket = serverSocket.accept();
			System.out.println("연결이 완료되었습니다.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			while(true) {
				String recvMsg = dis.readUTF();
				String result = "";
				String [] data = recvMsg.split(" ");
				int num1 = Integer.parseInt(data[0]);
				int num2 = Integer.parseInt(data[2]);
				String operator = data[1];
				switch(operator) {
				case "+" : 
					result = num1 + num2+"";
					break;
				case "-" : 
					result = num1 - num2+"";
					break;
				case "*" : 
					result = num1 * num2+"";
					break;
				case "/" : 
					result = num1 / num2+"";
					break;
					
				case "%" : 
					result = num1 % num2+"";
					break;
				}
				
			}
			// 1. 필요에 의해서 나누어야 함.
			// 2. 나눈 것을 연산
			// 3. 결과를 result에 담기
			
			dos.writeUTF(result);
			dos.flush();
			System.out.println(recvMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
