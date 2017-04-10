package com.github.tyurin23.skylook.skyscanner;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 15.02.17.
 */
public class ItineraryFilter {

	private Integer maxPrice;

	private RouteFilter departureFilter = new RouteFilter(this);

	private RouteFilter arrivalFilter = new RouteFilter(this);

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public ItineraryFilter setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
		return this;
	}

	public RouteFilter getDepartureFilter() {
		return departureFilter;
	}

	public RouteFilter getArrivalFilter() {
		return arrivalFilter;
	}

	public static final class RouteFilter {

		private ItineraryFilter parent;

		private Duration maxDuration;

		private LocalTime minDepartureTime;

		private LocalTime maxDepartureTime;

		private LocalTime minArrivalTime;

		private LocalTime maxArrivalTime;

		RouteFilter(ItineraryFilter parent) {
			this.parent = Objects.requireNonNull(parent);
		}

		public ItineraryFilter and() {
			return parent;
		}

		public Duration getMaxDuration() {
			return maxDuration;
		}

		public RouteFilter setMaxDuration(Duration maxDuration) {
			this.maxDuration = maxDuration;
			return this;
		}

		public LocalTime getMinDepartureTime() {
			return minDepartureTime;
		}

		public RouteFilter setMinDepartureTime(LocalTime minDepartureTime) {
			this.minDepartureTime = minDepartureTime;
			return this;
		}

		public LocalTime getMaxDepartureTime() {
			return maxDepartureTime;
		}

		public RouteFilter setMaxDepartureTime(LocalTime maxDepartureTime) {
			this.maxDepartureTime = maxDepartureTime;
			return this;
		}

		public LocalTime getMinArrivalTime() {
			return minArrivalTime;
		}

		public RouteFilter setMinArrivalTime(LocalTime minArrivalTime) {
			this.minArrivalTime = minArrivalTime;
			return this;
		}

		public LocalTime getMaxArrivalTime() {
			return maxArrivalTime;
		}

		public RouteFilter setMaxArrivalTime(LocalTime maxArrivalTime) {
			this.maxArrivalTime = maxArrivalTime;
			return this;
		}
	}
}
