package com.github.tyurin23.skylook.storage.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 19.02.17.
 */
public enum PlaceType {
	AIRPORT,
	CITY,
	COUNTRY;

	@JsonCreator
	public static PlaceType getByName(String type) {
		if (type != null) {
			for (PlaceType t : PlaceType.values()) {
				if (t.name().toLowerCase().equals(type.toLowerCase())) {
					return t;
				}
			}
			throw new IllegalArgumentException("PlaceType " + type + " not found");
		} else {
			return null;
		}
	}
}
