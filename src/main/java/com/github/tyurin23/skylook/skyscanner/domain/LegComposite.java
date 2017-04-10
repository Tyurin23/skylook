package com.github.tyurin23.skylook.skyscanner.domain;

import com.github.tyurin23.skylook.skyscanner.dto.Carrier;
import com.github.tyurin23.skylook.skyscanner.dto.FlightNumber;
import com.github.tyurin23.skylook.skyscanner.dto.Place;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class LegComposite {

	private String id;

	private Integer duration;

	private List<SegmentComposite> segments;

	private Place originStation;

	private Place destinationStation;

	private LocalDateTime departure;

	private LocalDateTime arrival;

	private String journeyMode;

	private List<Place> stops;

	private List<Carrier> carriers;

	private List<Carrier> operatingCarriers;

	private String directionality;

	private List<FlightNumber> flightNumbers;

	public String getId() {
		return id;
	}

	public LegComposite setId(String id) {
		this.id = id;
		return this;
	}

	public Integer getDuration() {
		return duration;
	}

	public LegComposite setDuration(Integer duration) {
		this.duration = duration;
		return this;
	}

	public List<SegmentComposite> getSegments() {
		return segments;
	}

	public LegComposite setSegments(List<SegmentComposite> segments) {
		this.segments = segments;
		return this;
	}

	public Place getOriginStation() {
		return originStation;
	}

	public LegComposite setOriginStation(Place originStation) {
		this.originStation = originStation;
		return this;
	}

	public Place getDestinationStation() {
		return destinationStation;
	}

	public LegComposite setDestinationStation(Place destinationStation) {
		this.destinationStation = destinationStation;
		return this;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public LegComposite setDeparture(LocalDateTime departure) {
		this.departure = departure;
		return this;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public LegComposite setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
		return this;
	}

	public String getJourneyMode() {
		return journeyMode;
	}

	public LegComposite setJourneyMode(String journeyMode) {
		this.journeyMode = journeyMode;
		return this;
	}

	public List<Place> getStops() {
		return stops;
	}

	public LegComposite setStops(List<Place> stops) {
		this.stops = stops;
		return this;
	}

	public List<Carrier> getCarriers() {
		return carriers;
	}

	public LegComposite setCarriers(List<Carrier> carriers) {
		this.carriers = carriers;
		return this;
	}

	public List<Carrier> getOperatingCarriers() {
		return operatingCarriers;
	}

	public LegComposite setOperatingCarriers(List<Carrier> operatingCarriers) {
		this.operatingCarriers = operatingCarriers;
		return this;
	}

	public String getDirectionality() {
		return directionality;
	}

	public LegComposite setDirectionality(String directionality) {
		this.directionality = directionality;
		return this;
	}

	public List<FlightNumber> getFlightNumbers() {
		return flightNumbers;
	}

	public LegComposite setFlightNumbers(List<FlightNumber> flightNumbers) {
		this.flightNumbers = flightNumbers;
		return this;
	}

	@Override
	public String toString() {
		return "LegComposite{" +
				"id='" + id + '\'' +
				", duration=" + duration +
				", segments=" + segments +
				", originStation=" + originStation +
				", destinationStation=" + destinationStation +
				", departure=" + departure +
				", arrival=" + arrival +
				", journeyMode='" + journeyMode + '\'' +
				", stops=" + stops +
				", carriers=" + carriers +
				", operatingCarriers=" + operatingCarriers +
				", directionality='" + directionality + '\'' +
				", flightNumbers=" + flightNumbers +
				'}';
	}
}
