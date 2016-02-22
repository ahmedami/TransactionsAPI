package org.ahmed.transactions.dto;

public class SumDto {
	
	private double sum;

	public SumDto(double sum) {
		super();
		this.sum = sum;
	}

	public SumDto() {
		super();
	}

	
	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
}
