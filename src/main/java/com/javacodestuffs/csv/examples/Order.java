package com.javacodestuffs.csv.examples;

public class Order {

	private long id;
	private int customerId;
	private double amount;
	private String status;

	public Order(long id, int customerId, double amount, String status) {
		this.id = id;
		this.customerId = customerId;
		this.amount = amount;
		this.status = status;
	}
//@Getter @Setter @toString()

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", amount=" + amount + ", status=" + status + "]";
	}
}