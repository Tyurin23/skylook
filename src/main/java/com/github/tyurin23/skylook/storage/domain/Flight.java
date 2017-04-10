package com.github.tyurin23.skylook.storage.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 28.02.17.
 */
public class Flight {

	@Id
	private String id;

	private LocalDateTime outboundTime;

	private LocalDateTime inboundTime;

	/**
	 * Duration in minutes
	 */
	private Integer duration;

	private Integer price;

	private String url;

	public String getId() {
		return id;
	}

	public Flight setId(String id) {
		this.id = id;
		return this;
	}

	public LocalDateTime getOutboundTime() {
		return outboundTime;
	}

	public Flight setOutboundTime(LocalDateTime outboundTime) {
		this.outboundTime = outboundTime;
		return this;
	}

	public LocalDateTime getInboundTime() {
		return inboundTime;
	}

	public Flight setInboundTime(LocalDateTime inboundTime) {
		this.inboundTime = inboundTime;
		return this;
	}

	public Integer getDuration() {
		return duration;
	}

	public Flight setDuration(Integer duration) {
		this.duration = duration;
		return this;
	}

	public Integer getPrice() {
		return price;
	}

	public Flight setPrice(Integer price) {
		this.price = price;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Flight setUrl(String url) {
		this.url = url;
		return this;
	}
}
