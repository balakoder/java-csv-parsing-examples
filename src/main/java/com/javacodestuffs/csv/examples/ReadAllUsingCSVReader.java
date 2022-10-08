package com.javacodestuffs.csv.examples;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadAllUsingCSVReader {
	public static void main(String args[]) {
		String filePath = "src/main/resources/orders2.csv";
		try {

			FileReader filereader = new FileReader(filePath);

			// create csvReader object and skip first Line
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> orderData = csvReader.readAll();
			System.out.println("--------------Order data is---------------------");
			for (String[] orders : orderData) {
				for (String orderString : orders) {
					System.out.print(orderString + "\t");
				}
				System.out.println();
			}
			System.out.println("----------------------------------------------");
		} catch (Exception ex) {
			System.out.println("Exception occured during reading the csv file" + ex);
		}
	}
}