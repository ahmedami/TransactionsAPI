package org.ahmed.transactions.dto;

public class TransactionDto {
	private String type;
	private double amount;
	private long parentId;
	
	public TransactionDto() {
		super();
	}
	public TransactionDto(String type, double amount, Long parentId) {
		super();
		this.type = type;
		this.amount = amount;
		this.parentId = parentId;
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
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "TransactionDto [type=" + type + ", amount=" + amount + ", parent_id=" + parentId + "]";
	}
	
}
