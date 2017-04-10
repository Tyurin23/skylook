package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class Carrier {

	@JsonProperty("Id")
	private Integer id;

	@JsonProperty("Code")
	private String code;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("ImageUrl")
	private String imageUrl;

	@JsonProperty("DisplayCode")
	private String displayCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDisplayCode() {
		return displayCode;
	}

	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}

	@Override
	public String toString() {
		return "Carrier{" +
				"id=" + id +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", displayCode='" + displayCode + '\'' +
				'}';
	}
}
