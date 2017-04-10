package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class Segment {

	@JsonProperty("Id")
	private Integer id;

	@JsonProperty("OriginStation")
	private Integer originStation;

	@JsonProperty("DestinationStation")
	private Integer destinationStation;

	@JsonProperty("DepartureDateTime")
	private LocalDateTime departureTime;

	@JsonProperty("ArrivalDateTime")
	private LocalDateTime arrivalTime;

	@JsonProperty("Carrier")
	private Integer carrier;

	@JsonProperty("OperatingCarrier")
	private Integer operationCarrier;

	@JsonProperty("Duration")
	private Duration duration;

	@JsonProperty("FlightNumber")
	private String flightNumber;

	@JsonProperty("JourneyMode")
	private String journeyMode;

	@JsonProperty("Directionality")
	private String directionality;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOriginStation() {
		return originStation;
	}

	public void setOriginStation(Integer originStation) {
		this.originStation = originStation;
	}

	public Integer getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(Integer destinationStation) {
		this.destinationStation = destinationStation;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getCarrier() {
		return carrier;
	}

	public void setCarrier(Integer carrier) {
		this.carrier = carrier;
	}

	public Integer getOperationCarrier() {
		return operationCarrier;
	}

	public void setOperationCarrier(Integer operationCarrier) {
		this.operationCarrier = operationCarrier;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getJourneyMode() {
		return journeyMode;
	}

	public void setJourneyMode(String journeyMode) {
		this.journeyMode = journeyMode;
	}

	public String getDirectionality() {
		return directionality;
	}

	public void setDirectionality(String directionality) {
		this.directionality = directionality;
	}

	@Override
	public String toString() {
		return "Segment{" +
				"id=" + id +
				", originStation=" + originStation +
				", destinationStation=" + destinationStation +
				", departureTime=" + departureTime +
				", arrivalTime=" + arrivalTime +
				", carrier=" + carrier +
				", operationCarrier=" + operationCarrier +
				", duration=" + duration +
				", flightNumber='" + flightNumber + '\'' +
				", journeyMode='" + journeyMode + '\'' +
				", directionality='" + directionality + '\'' +
				'}';
	}
}
