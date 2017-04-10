package com.github.tyurin23.skylook.skyscanner.domain;

import com.github.tyurin23.skylook.skyscanner.dto.Link;
import com.github.tyurin23.skylook.skyscanner.dto.Price;

import java.util.List;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class ItineraryComposite {

	private LegComposite outboundLeg;

	private LegComposite inboundLeg;

	private List<Price> pricingOptions;

	private Link detailsUrl;

	public LegComposite getOutboundLeg() {
		return outboundLeg;
	}

	public ItineraryComposite setOutboundLeg(LegComposite outboundLeg) {
		this.outboundLeg = outboundLeg;
		return this;
	}

	public LegComposite getInboundLeg() {
		return inboundLeg;
	}

	public ItineraryComposite setInboundLeg(LegComposite inboundLeg) {
		this.inboundLeg = inboundLeg;
		return this;
	}

	public List<Price> getPricingOptions() {
		return pricingOptions;
	}

	public ItineraryComposite setPricingOptions(List<Price> pricingOptions) {
		this.pricingOptions = pricingOptions;
		return this;
	}

	public Link getDetailsUrl() {
		return detailsUrl;
	}

	public ItineraryComposite setDetailsUrl(Link detailsUrl) {
		this.detailsUrl = detailsUrl;
		return this;
	}

	@Override
	public String toString() {
		return "ItineraryComposite{" +
				"outboundLeg=" + outboundLeg +
				", inboundLeg=" + inboundLeg +
				", pricingOptions=" + pricingOptions +
				", detailsUrl=" + detailsUrl +
				'}';
	}
}
