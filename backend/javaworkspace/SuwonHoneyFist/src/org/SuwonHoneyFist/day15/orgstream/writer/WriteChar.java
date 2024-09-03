package org.SuwonHoneyFist.day15.orgstream.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteChar {
    public static void main(String[] args) {

        Writer writer = null;
        try {
            writer = new FileWriter("src/org/SuwonHoneyFist/day15/orgstream/writer/writing.txt");
            char[] data = "Html/Css/Java".toCharArray(); // '=' 기호가 추가되었습니다.
            writer.write(data);
            writer.flush();
            System.out.println("파일 쓰기 완료");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
}
