package com.github.tyurin23.skylook.storage.domain;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 19.02.17.
 */
public class Place {

	private PlaceType type;

	private String code;

	public Place() {
	}

	public Place(String code) {
		this.code = code;
	}

	public Place(PlaceType type, String code) {
		this.type = type;
		this.code = code;
	}

	public PlaceType getType() {
		return type;
	}

	public Place setType(PlaceType type) {
		this.type = type;
		return this;
	}

	public String getCode() {
		return code;
	}

	public Place setCode(String code) {
		this.code = code;
		return this;
	}
}
