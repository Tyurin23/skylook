package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 14.02.17.
 */
public class Link {

	@JsonProperty("Uri")
	private String url;

	@JsonProperty("Body")
	private String body;

	@JsonProperty("Method")
	private String method;

	public String getUrl() {
		return url;
	}

	public Link setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getBody() {
		return body;
	}

	public Link setBody(String body) {
		this.body = body;
		return this;
	}

	public String getMethod() {
		return method;
	}

	public Link setMethod(String method) {
		this.method = method;
		return this;
	}

	@Override
	public String toString() {
		return "Link{" +
				"url='" + url + '\'' +
				", body='" + body + '\'' +
				", method='" + method + '\'' +
				'}';
	}
}
