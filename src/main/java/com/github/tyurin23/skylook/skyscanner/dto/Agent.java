package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class Agent {

	@JsonProperty("Id")
	private Integer id;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("ImageUrl")
	private String imageUrl;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("OptimisedForMobile")
	private Boolean optimisedForMobile;

	@JsonProperty("BookingNumber")
	private String bookingNumber;

	@JsonProperty("Type")
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getOptimisedForMobile() {
		return optimisedForMobile;
	}

	public void setOptimisedForMobile(Boolean optimisedForMobile) {
		this.optimisedForMobile = optimisedForMobile;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Agent{" +
				"id=" + id +
				", name='" + name + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", status='" + status + '\'' +
				", optimisedForMobile=" + optimisedForMobile +
				", bookingNumber='" + bookingNumber + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
