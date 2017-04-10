package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 14.02.17.
 */
public class Price {

	@JsonProperty("Agents")
	private List<Integer> agents;

	/**
	 * Время жизни в минутах
	 */
	@JsonProperty("QuoteAgeInMinutes")
	private Integer quoteAge;

	@JsonProperty("Price")
	private Integer price;

	@JsonProperty("DeeplinkUrl")
	private String url;

	public List<Integer> getAgents() {
		return agents;
	}

	public Price setAgents(List<Integer> agents) {
		this.agents = agents;
		return this;
	}

	public Integer getQuoteAge() {
		return quoteAge;
	}

	public Price setQuoteAge(Integer quoteAge) {
		this.quoteAge = quoteAge;
		return this;
	}

	public Integer getPrice() {
		return price;
	}

	public Price setPrice(Integer price) {
		this.price = price;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Price setUrl(String url) {
		this.url = url;
		return this;
	}

	@Override
	public String toString() {
		return "Price{" +
				"agents=" + agents +
				", quoteAge=" + quoteAge +
				", price=" + price +
				", url='" + url + '\'' +
				'}';
	}
}
