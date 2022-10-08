package com.javacodestuffs.csv.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ReadCSVUsingApacheCommonCSV {

	public static void main(String args[]) throws IOException {

		String filePath = "src/main/resources/orders.csv";
		String filePath1 = "src/main/resources/orders2.csv";
		System.out.println("Reading from CSV file using BufferedReader and String Split");
		List<Order> orders = readCSV(filePath);
		printOrder(orders);
		parseOrderCSVWithHeaders(filePath1);
		System.out.println("---------------Parsing CSV file-------------------------");
		parseOrderCSV(filePath);
	}

	private static void parseOrderCSV(String filePath) throws FileNotFoundException, IOException {
		String[] headers = {"id","customerId","amount","status"};
		CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withHeader(headers));
		for (CSVRecord order : parser) {
		 
			System.out.printf("%s\t%s\t%s\t%s\n", order.get("id"), order.get("customerId"), order.get("amount"),
					order.get("status"));
		}
		parser.close();
	}

	private static List<Order> readCSV(String filePath) throws FileNotFoundException, IOException {

		List<Order> orders = new ArrayList<Order>();

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = br.readLine();
		// Reading header, Ignoring
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			String[] orderLine = line.split(",");
			Long id = Long.parseLong(orderLine[0]);
			Integer customerId = Integer.parseInt(orderLine[1]);
			Double amount = Double.parseDouble(orderLine[2]);
			String status = orderLine[3].toString();

			orders.add(new Order(id, customerId, amount, status));
			
		}
		return orders;
	}

	public static void parseOrderCSVWithHeaders(String filePath) throws FileNotFoundException, IOException {
		CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withHeader());
		List<CSVRecord> records = parser.getRecords();
		for (CSVRecord order : records) {
			System.out.printf("%s\t%s\t%s\n", order.get("id"), order.get("customerId"), order.get("amount"),
					order.get("status"));
		}
		parser.close();
	}

	public static void printOrder(List<Order> orders) {

		System.out.println("--------------Order data is---------------------");
		for (Order order : orders) {
			System.out.println(order);
		}
		System.out.println("----------------------------------------------");
	}

}