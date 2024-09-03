package org.SuwonHoneyFist.day17.soket.chatting;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChattingServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        int port = 8888;
        InputStream is = null;
        OutputStream os = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        Scanner sc = new Scanner(System.in);
                
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("클라이언트의 연결을 기다리고 있습니다...");
            socket = serverSocket.accept();
            is = socket.getInputStream();
            os = socket.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
            System.out.println("클라이언트와 연결이 되었습니다.");

            while (true) {
                String recvMsg = dis.readUTF();  
                System.out.println("클라이언트(상대) : " + recvMsg);
                if("end".equals(recvMsg)) {
                    System.out.println("상대방이 대화를 종료했습니다.");
                    break;
                }
                System.out.print("서버(나) : ");
                String sendMsg = sc.nextLine();  
                dos.writeUTF(sendMsg);
                dos.flush();
                if("end".equals(sendMsg)) {
                    System.out.println("채팅을 종료합니다.");
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
