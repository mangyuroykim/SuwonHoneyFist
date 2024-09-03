package org.SuwonHoneyFist.day15.orgstream.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Exam_WriteByte {
	public static void main(String[] args) {
		OutputStream os = null;
		
		try {
			os = new FileOutputStream("src/org/SuwonHoneyFist/day15/orgstream/outputstream/reading,text");
			byte [] data = "한번 더 입출력".getBytes();
			os.write(data);
			os.flush();
			System.out.println("파일 쓰기 완료");
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {{
			e.printStackTrace();
		}
	}
}
