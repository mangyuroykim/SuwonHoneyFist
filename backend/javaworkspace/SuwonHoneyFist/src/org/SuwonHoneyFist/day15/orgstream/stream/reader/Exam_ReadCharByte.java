package org.SuwonHoneyFist.day15.orgstream.stream.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exam_ReadCharByte {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader reader = null;
		try {
			reader = new FileReader("src/org/SuwonHoneyFist/day15/orgstream/stream/reader/reading.txt");
		int readCount;
		char[] cBuf = new char[3];
		String result = "";
		while(true) {
			readCount =reader.read(cBuf);
			if(readCount == -1) break;
			result += new String(cBuf, 0 , readCount);
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

}
}
