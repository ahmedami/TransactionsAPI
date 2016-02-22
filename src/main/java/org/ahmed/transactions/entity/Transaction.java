package org.ahmed.transactions.entity;

public class Transaction {
	public Transaction() {
		super();
	}
	public Transaction(Long id, String type, double amount, Long parentId) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.parentId = parentId;
	}
	private Long id;
	private String type;
	private double amount;
	private Long parentId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
