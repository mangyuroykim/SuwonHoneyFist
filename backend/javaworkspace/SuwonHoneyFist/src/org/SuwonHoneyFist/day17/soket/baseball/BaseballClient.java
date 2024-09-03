package org.SuwonHoneyFist.day17.soket.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BaseballClient {
    public static void main(String[] args) {
        String address = "192.168.160.238";
        int port = 8989;

        try (Socket socket = new Socket(address, port);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            System.out.println("클라이언트 소켓을 생성하였습니다.");

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("게임 준비 완료");

                // 사용자로부터 숫자 입력 받음
                System.out.println("숫자 입력(띄어쓰기로 구분) ex 1 2 3");
                System.out.print("--> ");
                String sendMsg = sc.nextLine();
                dos.writeUTF(sendMsg);
                dos.flush();

                // 결과 받음
                String recvMsg = dis.readUTF();
                System.out.println(recvMsg);

                // 게임 종료 확인
                if (recvMsg.startsWith("3 스트라이크")) {
                    System.out.println("아웃! 게임 종료!");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
