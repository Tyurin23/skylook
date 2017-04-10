package com.github.tyurin23.skylook.storage.domain;

import com.github.tyurin23.skylook.skyscanner.domain.ItineraryComposite;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 19.02.17.
 */
public class FlightSearchResult {

	@Id
	private String id;

	private String session;

	private LocalDateTime searchTime;

	private LocalDate outboundDate;

	private LocalDate inboundDate;

	private Place originPlace;

	private Place destinationPlace;

	List<ItineraryComposite> itineraries;

	public String getId() {
		return id;
	}

	public FlightSearchResult setId(String id) {
		this.id = id;
		return this;
	}

	public String getSession() {
		return session;
	}

	public FlightSearchResult setSession(String session) {
		this.session = session;
		return this;
	}

	public LocalDateTime getSearchTime() {
		return searchTime;
	}

	public FlightSearchResult setSearchTime(LocalDateTime searchTime) {
		this.searchTime = searchTime;
		return this;
	}

	public LocalDate getOutboundDate() {
		return outboundDate;
	}

	public FlightSearchResult setOutboundDate(LocalDate outboundDate) {
		this.outboundDate = outboundDate;
		return this;
	}

	public LocalDate getInboundDate() {
		return inboundDate;
	}

	public FlightSearchResult setInboundDate(LocalDate inboundDate) {
		this.inboundDate = inboundDate;
		return this;
	}

	public Place getOriginPlace() {
		return originPlace;
	}

	public FlightSearchResult setOriginPlace(Place originPlace) {
		this.originPlace = originPlace;
		return this;
	}

	public Place getDestinationPlace() {
		return destinationPlace;
	}

	public FlightSearchResult setDestinationPlace(Place destinationPlace) {
		this.destinationPlace = destinationPlace;
		return this;
	}

	public List<ItineraryComposite> getItineraries() {
		return itineraries;
	}

	public FlightSearchResult setItineraries(List<ItineraryComposite> itineraries) {
		this.itineraries = itineraries;
		return this;
	}
}
