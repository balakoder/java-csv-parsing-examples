package com.javacodestuffs.csv.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadCSVUsingScanner {

	public static void main(String args[]) throws FileNotFoundException {

		String filePath = "src/main/resources/orders.csv";
	
		List<List<String>> orderList = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				orderList.add(getOrderFromLine(scanner.nextLine()));
			}
		}
		System.out.println("--------------Order CSV data using  ReaderCSVUsingScanner ---------------------");
		for (List<String> order : orderList) {
			System.out.println(order);
		}
		System.out.println("----------------------------------------------");
	}

	private static List<String> getOrderFromLine(String orderLine) {
		List<String> values = new ArrayList<String>();
		try (Scanner scan = new Scanner(orderLine)) {
			scan.useDelimiter(",");
			while (scan.hasNext()) {
				values.add(scan.next());
			}
		}
		return values;
	}

}
