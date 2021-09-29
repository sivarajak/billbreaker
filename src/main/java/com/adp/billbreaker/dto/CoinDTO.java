package com.adp.billbreaker.dto;

public class CoinDTO {
	
	private double value;
	
	private int count;

	public CoinDTO(double value, int count) {
		super();
		this.value = value;
		this.count = count;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Coin Value: " + this.value + " Coin Count : " + this.count;
	}

}
