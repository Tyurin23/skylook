package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class Itinerary {

	@JsonProperty("OutboundLegId")
	private String outboundLegId;

	@JsonProperty("InboundLegId")
	private String inboundLegId;

	@JsonProperty("PricingOptions")
	private List<Price> pricingOptions;

	@JsonProperty("BookingDetailsLink")
	private Link detailsUrl;

	public String getOutboundLegId() {
		return outboundLegId;
	}

	public Itinerary setOutboundLegId(String outboundLegId) {
		this.outboundLegId = outboundLegId;
		return this;
	}

	public String getInboundLegId() {
		return inboundLegId;
	}

	public Itinerary setInboundLegId(String inboundLegId) {
		this.inboundLegId = inboundLegId;
		return this;
	}

	public List<Price> getPricingOptions() {
		return pricingOptions;
	}

	public Itinerary setPricingOptions(List<Price> pricingOptions) {
		this.pricingOptions = pricingOptions;
		return this;
	}

	public Link getDetailsUrl() {
		return detailsUrl;
	}

	public Itinerary setDetailsUrl(Link detailsUrl) {
		this.detailsUrl = detailsUrl;
		return this;
	}

	@Override
	public String toString() {
		return "Itinerary{" +
				"outboundLegId='" + outboundLegId + '\'' +
				", inboundLegId='" + inboundLegId + '\'' +
				", pricingOptions=" + pricingOptions +
				", detailsUrl=" + detailsUrl +
				'}';
	}
}
