package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.tyurin23.skylook.skyscanner.utils.DurationDeserializer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class Leg {

	@JsonProperty("Id")
	private String id;

	@JsonProperty("SegmentIds")
	private List<Integer> segments;

	@JsonProperty("OriginStation")
	private Integer originStation;

	@JsonProperty("DestinationStation")
	private Integer destinationStation;

	@JsonProperty("Departure")
	private LocalDateTime departure;

	@JsonProperty("Arrival")
	private LocalDateTime arrival;

	@JsonProperty("Duration")
	@JsonDeserialize(using = DurationDeserializer.class)
	private Duration duration;

	@JsonProperty("JourneyMode")
	private String journeyMode;

	@JsonProperty("Stops")
	private List<Integer> stops;

	@JsonProperty("Carriers")
	private List<Integer> carriers;

	@JsonProperty("OperatingCarriers")
	private List<Integer> operatingCarriers;

	@JsonProperty("Directionality")
	private String directionality;

	@JsonProperty("FlightNumbers")
	private List<FlightNumber> flightNumbers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Integer> getSegments() {
		return segments;
	}

	public void setSegments(List<Integer> segments) {
		this.segments = segments;
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

	public LocalDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getJourneyMode() {
		return journeyMode;
	}

	public void setJourneyMode(String journeyMode) {
		this.journeyMode = journeyMode;
	}

	public List<Integer> getStops() {
		return stops;
	}

	public void setStops(List<Integer> stops) {
		this.stops = stops;
	}

	public List<Integer> getCarriers() {
		return carriers;
	}

	public void setCarriers(List<Integer> carriers) {
		this.carriers = carriers;
	}

	public List<Integer> getOperatingCarriers() {
		return operatingCarriers;
	}

	public void setOperatingCarriers(List<Integer> operatingCarriers) {
		this.operatingCarriers = operatingCarriers;
	}

	public String getDirectionality() {
		return directionality;
	}

	public void setDirectionality(String directionality) {
		this.directionality = directionality;
	}

	public List<FlightNumber> getFlightNumbers() {
		return flightNumbers;
	}

	public void setFlightNumbers(List<FlightNumber> flightNumbers) {
		this.flightNumbers = flightNumbers;
	}

	@Override
	public String toString() {
		return "Leg{" +
				"id='" + id + '\'' +
				", segments=" + segments +
				", originStation=" + originStation +
				", destinationStation=" + destinationStation +
				", departure=" + departure +
				", arrival=" + arrival +
				", duration=" + duration +
				", journeyMode='" + journeyMode + '\'' +
				", stops=" + stops +
				", carriers=" + carriers +
				", operatingCarriers=" + operatingCarriers +
				", directionality='" + directionality + '\'' +
				", flightNumbers=" + flightNumbers +
				'}';
	}
}
