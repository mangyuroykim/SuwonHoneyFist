package org.SuwonHoneyFist.day15.orgstream.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Exam_WriteByteOff {
    public static void main(String[] args) {
        OutputStream os = null;

        try {
            os = new FileOutputStream("src/org/SuwonHoneyFist/day15/orgstream/outputstream/writing.txt");
            byte[] data = "마지막 입출력".getBytes();
            os.write(data);
            System.out.println("파일 쓰기 완료");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close(); // 파일을 닫음
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
