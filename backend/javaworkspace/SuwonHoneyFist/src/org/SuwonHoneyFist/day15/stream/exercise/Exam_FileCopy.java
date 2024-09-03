package org.SuwonHoneyFist.day15.stream.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Exam_FileCopy {
	public static void main(String[] args) {
		// C드라이브에 있는 파일을 E드라이브로 복사해보자~!
		// C:\Temp\copyimg.jpg -> C:\COPY\copyimg.jpg
		// 입력스트림과 출력스트림을 다 써야함.
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("C:\\Temp\\copyimg.jpg");
			os = new FileOutputStream("C:\\COPY\\copyimg.jpg");
			byte[] bytes = new byte[1024];
			int readCount;
			while ((readCount = is.read(bytes)) != -1) {
				os.write(bytes, 0, readCount);
				os.flush();
			}
			System.out.println("복사가 완료되었습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
