package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class PollResponseData {

	@JsonProperty("SessionKey")
	private String sessionKey;

	@JsonProperty("Query")
	private Map<String, Object> query;

	/**
	 * UpdatesComplete
	 */
	@JsonProperty("Status")
	private String status;

	/**
	 * Маршруты
	 */
	@JsonProperty("Itineraries")
	private List<Itinerary> itineraries;

	/**
	 * Путь
	 */
	@JsonProperty("Legs")
	private List<Leg> legs;

	/**
	 * Отрезки пути
	 */
	@JsonProperty("Segments")
	private List<Segment> segments;

	/**
	 * Перевозчики
	 */
	@JsonProperty("Carriers")
	private List<Carrier> carriers;

	/**
	 * Агенты
	 */
	@JsonProperty("Agents")
	private List<Agent> agents;

	/**
	 * Места
	 */
	@JsonProperty("Places")
	private List<Place> places;

	/**
	 * Валюты
	 */
	@JsonProperty("Currencies")
	private List<Currency> currencies;

	public String getSessionKey() {
		return sessionKey;
	}

	public PollResponseData setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
		return this;
	}

	public Map<String, Object> getQuery() {
		return query;
	}

	public PollResponseData setQuery(Map<String, Object> query) {
		this.query = query;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public PollResponseData setStatus(String status) {
		this.status = status;
		return this;
	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public PollResponseData setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
		return this;
	}

	public List<Leg> getLegs() {
		return legs;
	}

	public PollResponseData setLegs(List<Leg> legs) {
		this.legs = legs;
		return this;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public PollResponseData setSegments(List<Segment> segments) {
		this.segments = segments;
		return this;
	}

	public List<Carrier> getCarriers() {
		return carriers;
	}

	public PollResponseData setCarriers(List<Carrier> carriers) {
		this.carriers = carriers;
		return this;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public PollResponseData setAgents(List<Agent> agents) {
		this.agents = agents;
		return this;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public PollResponseData setPlaces(List<Place> places) {
		this.places = places;
		return this;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public PollResponseData setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
		return this;
	}
}
