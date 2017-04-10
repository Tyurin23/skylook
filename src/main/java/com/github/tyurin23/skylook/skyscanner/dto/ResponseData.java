package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 08.02.17.
 */
public class ResponseData {

	@JsonProperty("Locales")
	private List<Locale> locales;

	@JsonProperty("Currencies")
	private List<Currency> currencies;

	public List<Locale> getLocales() {
		return locales;
	}

	public void setLocales(List<Locale> locales) {
		this.locales = locales;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
}
