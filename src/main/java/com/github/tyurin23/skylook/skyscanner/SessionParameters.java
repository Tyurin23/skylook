package com.github.tyurin23.skylook.skyscanner;

import java.time.LocalDate;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class SessionParameters {

	public enum CabinClass {
		ECONOMY,
		PREMIUMECONOMY,
		BUSINESS,
		FIRST
	}

	private CabinClass cabinClass = CabinClass.ECONOMY;

	private String country;

	private String currency;

	private String locale;

	private String originPlace;

	private String destinationPlace;

	private LocalDate outboundDate;

	private LocalDate inboundDate;

	/**
	 * 1-8
	 */
	private Integer adults = 1;

	/**
	 * 0-8
	 */
	private Integer children = 0;

	/**
	 * 0-8
	 */
	private Integer infants = 0;

	public CabinClass getCabinClass() {
		return cabinClass;
	}

	public SessionParameters setCabinClass(CabinClass cabinClass) {
		this.cabinClass = cabinClass;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public SessionParameters setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public SessionParameters setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getLocale() {
		return locale;
	}

	public SessionParameters setLocale(String locale) {
		this.locale = locale;
		return this;
	}

	public String getOriginPlace() {
		return originPlace;
	}

	public SessionParameters setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
		return this;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public SessionParameters setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
		return this;
	}

	public LocalDate getOutboundDate() {
		return outboundDate;
	}

	public SessionParameters setOutboundDate(LocalDate outboundDate) {
		this.outboundDate = outboundDate;
		return this;
	}

	public LocalDate getInboundDate() {
		return inboundDate;
	}

	public SessionParameters setInboundDate(LocalDate inboundDate) {
		this.inboundDate = inboundDate;
		return this;
	}

	public Integer getAdults() {
		return adults;
	}

	public SessionParameters setAdults(Integer adults) {
		this.adults = adults;
		return this;
	}

	public Integer getChildren() {
		return children;
	}

	public SessionParameters setChildren(Integer children) {
		this.children = children;
		return this;
	}

	public Integer getInfants() {
		return infants;
	}

	public SessionParameters setInfants(Integer infants) {
		this.infants = infants;
		return this;
	}
}
