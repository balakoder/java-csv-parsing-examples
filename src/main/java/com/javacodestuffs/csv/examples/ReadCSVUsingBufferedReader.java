package com.javacodestuffs.csv.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVUsingBufferedReader {

	public static void main(String args[]) {

		String filePath = "src/main/resources/orders.csv";
		System.out.println("--------------Order data is---------------------");
		List<Order> orders = readOrdersFromCSV(filePath);

		for (Order order : orders) {
			System.out.println(order);
		}
		System.out.println("----------------------------------------------");
	}

	private static List<Order> readOrdersFromCSV(String fileName) {
		List<Order> orders = new ArrayList<Order>();

		try {
			FileReader fileReader = new FileReader(fileName);

			// create BufferedReader object
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			while ((line = br.readLine()) != null) {
				String[] order = line.split(",");// separate line by comma or we can use any valid delimeter in csv file
				orders.add(getOrder(order));
			}

		} catch (IOException ex) {
			System.out.println("Exception occured during reading the csv file" + ex);
		}

		return orders;
	}

	private static Order getOrder(String[] order) {

		Long id = Long.parseLong(order[0]);
		int customerId = Integer.parseInt(order[1]);
		Double amount = Double.parseDouble(order[2]);
		String status = order[3].toString();
		return new Order(id, customerId, amount, status);
	}

}
