package com.apple.oa.data;

import java.io.Serializable;

public class MostValuableCustomerResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	private Double value;

	public MostValuableCustomerResponse(String name, Double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[Customer =" + name + ", total purchase value =" + value + "]";
	}

}