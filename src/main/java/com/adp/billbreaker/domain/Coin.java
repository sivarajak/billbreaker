package com.adp.billbreaker.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coin  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4244741818688275216L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private double value;
	
	private int count;

	public Coin() {
		
	}
	
	public Coin(double value, int count) {
		super();
		this.value = value;
		this.count = count;
	}
	
	public Coin(int id, double value, int count) {
		super();
		this.id = id;
		this.value = value;
		this.count = count;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
