package com.github.tyurin23.skylook.skyscanner;

import com.github.tyurin23.skylook.skyscanner.domain.ItineraryComposite;
import com.github.tyurin23.skylook.skyscanner.dto.Price;
import com.github.tyurin23.skylook.skyscanner.exceptions.NotModifiedException;
import com.github.tyurin23.skylook.skyscanner.exceptions.TooManyRequests;
import com.github.tyurin23.skylook.storage.domain.FlightSearchResult;
import com.github.tyurin23.skylook.storage.domain.Place;
import com.github.tyurin23.skylook.storage.domain.PlaceType;
import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 15.02.17.
 */
public class SkyScannerServiceTest {

	private String location = "http://partners.api.skyscanner.net/apiservices/pricing/uk1/v1.0/322d9e3208e74e34a3b0a2cf9289292d_rrsqbjcb_06a13f0a788e803fcc56e78802891a26";

	private SkyScannerService service;


	private MongoTemplate mongo;

	@Before
	public void setUp() throws Exception {
		service = new SkyScannerService(new SkyRestRepository());
		MongoClient client = new MongoClient();

		this.mongo = new MongoTemplate(client, "flights");
	}

	@Test
	public void getSavedFlights() throws Exception {
		Criteria criteria = Criteria
				.where("inboundDate").is(LocalDate.of(2017, 5, 8))
				.and("outboundDate").is(LocalDate.of(2017, 4, 22))
				.and("originPlace.code").is("MOW")
				.and("originPlace.type").is(PlaceType.CITY)
//				.and("destinationPlace.code").is("BKK")
//				.and("destinationPlace.type").is(PlaceType.CITY);
		;

//		List<FlightSearchResult> result = mongo.findAll(FlightSearchResult.class, "results");
//		List<FlightSearchResult> result = mongo.find(new Query(), FlightSearchResult.class, "results");
		List<FlightSearchResult> result = mongo.find(new Query(criteria), FlightSearchResult.class, "results");
		System.out.println(result.size());
		result.forEach(r -> System.out.println(r.getInboundDate() + " " + r.getOutboundDate()));

	}

	@Test
	public void getFlightsOnWeekend() throws Exception {
		List<String> cities = Arrays.asList("BKK", "Barcelona", "Paris", "Budapest", "Prague");


		List<LocalDate> outboundDates = new LinkedList<>();
		for (LocalDate d = LocalDate.now(); d.isBefore(LocalDate.now().plusMonths(1)); d = d.plusDays(1)) {
			if (d.getDayOfWeek() == DayOfWeek.FRIDAY || d.getDayOfWeek() == DayOfWeek.SATURDAY) {
				outboundDates.add(d);
			}
		}

		List<LocalDate> inboundDates = new LinkedList<>();
		for (LocalDate d = LocalDate.now(); d.isBefore(LocalDate.now().plusMonths(1)); d = d.plusDays(1)) {
			if (d.getDayOfWeek() == DayOfWeek.SUNDAY || d.getDayOfWeek() == DayOfWeek.MONDAY) {
				inboundDates.add(d);
			}
		}

		for (String city : cities) {
			for (LocalDate outboundDate : outboundDates) {
				for (LocalDate inboundDate : inboundDates) {
					Thread.sleep(1000);

					boolean done = true;
					int repeats = 0;
					do {
						SessionParameters parameters = new SessionParameters()
								.setLocale("ru-RU")
								.setCurrency("RUB")
								.setCountry("RU")
								.setOriginPlace("MOW")
								.setDestinationPlace(city)
								.setOutboundDate(outboundDate)
								.setInboundDate(inboundDate);


						List<ItineraryComposite> itineraries = null;
						try {
							itineraries = service.getItineraries(parameters, new ItineraryFilter());
						} catch (NotModifiedException e) {
							System.out.println("Not modified");
							continue;
						} catch (TooManyRequests e) {
							System.out.println("Too many requests! Repeat");
							done = false;
							Thread.sleep((long) (1000L * Math.pow(2, repeats)));
							repeats++;
							continue;
						}

						FlightSearchResult result = new FlightSearchResult();
						result.setSearchTime(LocalDateTime.now());
						result.setItineraries(itineraries);
						result.setInboundDate(parameters.getInboundDate());
						result.setOutboundDate(parameters.getOutboundDate());
						result.setOriginPlace(new Place(PlaceType.CITY, parameters.getOriginPlace()));
						result.setDestinationPlace(new Place(PlaceType.CITY, parameters.getDestinationPlace()));

						mongo.insert(result);

					} while (!done);
									}

			}
		}

	}

	@Test
	public void getFlights() throws Exception {
		SessionParameters parameters = new SessionParameters()
				.setLocale("ru-RU")
				.setCurrency("RUB")
				.setCountry("RU")
				.setOriginPlace("MOW")
				.setDestinationPlace("BKK")
				.setOutboundDate(LocalDate.of(2017, 4, 22))
				.setInboundDate(LocalDate.of(2017, 5, 8));

		ItineraryFilter filter = new ItineraryFilter();
//				.setMaxPrice(35000)
//				.getDepartureFilter()
//					.setMaxDuration(Duration.ofHours(15))
//					.and()
//				.getArrivalFilter()
//					.setMaxDuration(Duration.ofHours(15))
//				.and();
		List<ItineraryComposite> itineraries = service.getItineraries(parameters, filter);
//		List<ItineraryComposite> itineraries = service.getItineraries(location, filter);

		FlightSearchResult result = new FlightSearchResult();
		result.setSearchTime(LocalDateTime.now());
		result.setItineraries(itineraries);
		result.setInboundDate(parameters.getInboundDate());
		result.setOutboundDate(parameters.getOutboundDate());
		result.setOriginPlace(new Place(PlaceType.CITY, parameters.getOriginPlace()));
		result.setDestinationPlace(new Place(PlaceType.CITY, parameters.getDestinationPlace()));

		mongo.insert(result, "results");


		itineraries.forEach(i -> {
			Price price = i.getPricingOptions().stream().sorted(Comparator.comparing(Price::getPrice)).findFirst().orElse(null);

			System.out.println(String.format("Outbound:\t%s - %s (%d h) - %s",
					i.getOutboundLeg().getDeparture(),
					i.getOutboundLeg().getArrival(),
					i.getOutboundLeg().getDuration() / 60,
					i.getOutboundLeg().getFlightNumbers().get(0).getNumber()
			));
			System.out.println(String.format("Inboud:\t%s - %s (%d h) - %s",
					i.getInboundLeg().getDeparture(),
					i.getInboundLeg().getArrival(),
					i.getInboundLeg().getDuration() / 60,
					i.getInboundLeg().getFlightNumbers().get(0).getNumber()
			));
			System.out.println(price.getPrice() + " RUB");
			System.out.println(price.getUrl());
			System.out.println();
		});

	}
}