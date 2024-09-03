package org.SuwonHoneyFist.day16.soket.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalClient {
	public static void main(String[] args) {
		Socket socket = null;
		String address = "192.168.160.238";
		int port = 9999;
		OutputStream os = null;
		InputStream is = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket(address,port);
			System.out.println("서버와의 연결이 완료되었습니다..");
			os = socket.getOutputStream();
			is= socket.getInputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.print("계산식(빈칸으로 띄어 입력, 예 24 + 42) >> ");
			String sendMsg = sc.nextLine();
			dos.writeUTF(sendMsg);
			dos.flush();
			String recvMsg = dis.readUTF();
			System.out.println("계산결과 : " + recvMsg);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
