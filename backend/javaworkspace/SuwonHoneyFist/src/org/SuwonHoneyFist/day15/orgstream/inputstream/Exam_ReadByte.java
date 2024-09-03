package org.SuwonHoneyFist.day15.orgstream.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exam_ReadByte {
	public static void main(String[] args) {
		InputStream is = null;

		try {
			is = new FileInputStream("src/org/SuwonHoneyFist/day15/orgstream/inputstream/reading,text");
				byte [] readBytes = new byte[3];
				int readCount;
				String result = "";
				while(true) {
					readCount = is.read(readBytes);
					if(readCount ==-1) break;
					result += new String(readBytes, 0 , readCount);
				}
				System.out.println(result);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	