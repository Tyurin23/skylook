package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 08.02.17.
 */
public class Locale {

	@JsonProperty("Code")
	private String code;

	@JsonProperty("Name")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Locale{" +
				"code='" + code + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
