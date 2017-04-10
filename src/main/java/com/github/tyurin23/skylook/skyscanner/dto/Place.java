package com.github.tyurin23.skylook.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 09.02.17.
 */
public class Place {

	@JsonProperty("Id")
	private Integer id;

	@JsonProperty("ParentId")
	private Integer parentId;

	@JsonProperty("Code")
	private String code;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Place{" +
				"id=" + id +
				", parentId=" + parentId +
				", code='" + code + '\'' +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
