package org.SuwonHoneyFist.day16.soket.basic;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String[] args) {
		String address = "127.0.0.1";
		int port = 8888;
		try {
			Socket socket = new Socket(address, port);
			System.out.println("서버와 연결돠었습니다.");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
