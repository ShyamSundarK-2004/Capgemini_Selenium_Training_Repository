package com.seleniumparametrization.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class Data_From_CSV {

	@Test
	public void readingDataFromCSV() throws IOException {

		FileReader fr = new FileReader("./src/test/resources/orangehrms.testscriptdata/testscript.csv");
//		int i;
//		while ((i = fr.read()) != -1) {
//			System.out.print((char) i);
//		}

		String line = "";
		BufferedReader br = new BufferedReader(fr);
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			System.out.println(data[0] + "---->" + data[1]);
		}
	}
}
