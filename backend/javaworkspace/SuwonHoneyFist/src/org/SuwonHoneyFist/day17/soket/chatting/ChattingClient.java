package org.SuwonHoneyFist.day17.soket.chatting;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChattingClient {
    public static void main(String[] args) {
        String address = "192.168.60.225";  // 서버 주소
        int port = 8888;  // 서버와 동일한 포트
        Socket socket = null;
        Scanner sc = new Scanner(System.in);
        InputStream is = null;
        OutputStream os = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            socket = new Socket(address, port);
            System.out.println("서버와 연결이 완료되었습니다!");
            is = socket.getInputStream();
            os = socket.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);

            while (true) {
                System.out.print("클라이언트(나) : ");
                String sendMsg = sc.nextLine();  
                dos.writeUTF(sendMsg);
                dos.flush();
                if("end".equals(sendMsg)) {
                    System.out.println("채팅을 종료합니다.");
                    break;
                }

                String recvMsg = dis.readUTF();  
                System.out.println("서버(상대) : " + recvMsg);
                if("end".equals(recvMsg)) {
                    System.out.println("상대방이 대화를 종료했습니다.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
