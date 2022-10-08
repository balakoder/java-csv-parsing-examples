package com.javacodestuffs.csv.examples;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class ReadCSVByLine {
	public static void main(String args[]) {
		try {
			String filePath = "src/main/resources/orders.csv";
			FileReader filereader = new FileReader(filePath);

			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			System.out.println("--------------Order data is---------------------");
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String order : nextRecord) {
					System.out.print(order + "\t");
				}
			System.out.println();
			}
		} catch (Exception ex) {
			System.out.println("Exception occured during reading the csv file" + ex);
		}
	}

}