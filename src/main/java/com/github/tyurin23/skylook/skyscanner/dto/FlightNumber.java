package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 14.02.17.
 */
public class FlightNumber {

	@JsonProperty("FlightNumber")
	private String number;

	@JsonProperty("CarrierId")
	private Integer carrier;

	public String getNumber() {
		return number;
	}

	public FlightNumber setNumber(String number) {
		this.number = number;
		return this;
	}

	public Integer getCarrier() {
		return carrier;
	}

	public FlightNumber setCarrier(Integer carrier) {
		this.carrier = carrier;
		return this;
	}

	@Override
	public String toString() {
		return "FlightNumber{" +
				"number='" + number + '\'' +
				", carrier=" + carrier +
				'}';
	}
}
