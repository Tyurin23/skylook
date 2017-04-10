package com.github.tyurin23.skylook.skyscanner;

import com.github.tyurin23.skylook.skyscanner.dto.Currency;
import com.github.tyurin23.skylook.skyscanner.dto.Locale;
import com.github.tyurin23.skylook.skyscanner.dto.PollResponseData;
import com.github.tyurin23.skylook.skyscanner.dto.ResponseData;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 08.02.17.
 */
public class SkyRestRepositoryIT {

	private SkyRestRepository restRepository;

	private String location = "http://partners.api.skyscanner.net/apiservices/pricing/uk1/v1.0/1d1c4d6e5e9649cea2a130207d600f7b_rrsqbjcb_06a13f0a788e803fcc56e78802891a26";

	@Before
	public void setUp() throws Exception {

		restRepository = new SkyRestRepository();
	}

	@Test
	public void getLocales() throws Exception {
		ResponseData response = restRepository.getLocales();

		assertNotNull(response);
		assertNotNull(response.getLocales());
		assertTrue(response.getLocales().size() > 0);
		assertTrue(response.getLocales().stream().map(Locale::getCode).allMatch(Objects::nonNull));
		assertTrue(response.getLocales().stream().map(Locale::getName).allMatch(Objects::nonNull));
	}

	@Test
	public void getCurrencies() throws Exception {
		ResponseData response = restRepository.getCurrencies();

		assertNotNull(response);
		assertNotNull(response.getCurrencies());
		assertTrue(response.getCurrencies().size() > 0);
		assertTrue(response.getCurrencies().stream().map(Currency::getCode).allMatch(Objects::nonNull));

	}

	@Test
	public void createSession() throws Exception {
		SessionParameters parameters = new SessionParameters()
				.setLocale("ru-RU")
				.setCurrency("RUB")
				.setCountry("RU")
				.setOriginPlace("MOW")
				.setDestinationPlace("BKK")
				.setOutboundDate(LocalDate.of(2017, 4, 22))
				.setInboundDate(LocalDate.of(2017, 5, 8));

		String location = restRepository.createSession(parameters);

		System.out.println(location);
		assertNotNull(location);

		PollResponseData response = restRepository.pollSession(location);

		assertNotNull(response);
		System.out.println(response.getQuery());
	}

	@Test
	public void pollSession() throws Exception {
		PollResponseData response = restRepository.pollSession(location);

		assertNotNull(response);
		System.out.println(response.getQuery());

		response.getItineraries().stream()
				.flatMap(i -> i.getPricingOptions().stream())
				.map(p -> p.getPrice())
				.sorted()
				.forEachOrdered(System.out::println);

	}
}