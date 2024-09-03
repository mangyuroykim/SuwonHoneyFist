package org.SuwonHoneyFist.day15.orgstream.stream.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exam_Read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader reader = null;
		
		try {
			reader = new FileReader("src/org/SuwonHoneyFist/day15/orgstream/stream/reader/reading.txt");
			int readData;
			while((readData = reader.read()) != -1)	{ //한글자씩 읽고 없으면 그만
				System.out.print((char)readData);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
