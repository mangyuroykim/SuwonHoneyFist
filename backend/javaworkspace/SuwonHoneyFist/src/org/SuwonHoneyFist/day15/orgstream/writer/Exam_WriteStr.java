package org.SuwonHoneyFist.day15.orgstream.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Exam_WriteStr {
    public static void main(String[] args) {
        Writer writer = null;
        try {
            writer = new FileWriter("src/org/SuwonHoneyFist/day15/orgstream/writer/writing.txt");
            writer.write("Html/Css/Java");
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
