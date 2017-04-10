package com.github.tyurin23.skylook.skyscanner;

import com.github.tyurin23.skylook.skyscanner.dto.PollResponseData;
import com.github.tyurin23.skylook.skyscanner.dto.ResponseData;
import com.github.tyurin23.skylook.skyscanner.exceptions.NotModifiedException;
import com.github.tyurin23.skylook.skyscanner.exceptions.TooManyRequests;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.format.DateTimeFormatter;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 08.02.17.
 */
public class SkyRestRepository implements SkyRepository {

	private RestTemplate client;

	private String baseUrl = "http://partners.api.skyscanner.net/apiservices";

	private String apiKey = "prtl6749387986743898559646983194";

	public SkyRestRepository() {
		this(new RestTemplate());
	}

	public SkyRestRepository(RestTemplate client) {
		this.client = client;
	}

	@Override
	public ResponseData getLocales() {
		URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/reference/v1.0/locales")
				.queryParam("apikey", apiKey)
				.build().toUri();

		RequestEntity<?> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();

		ResponseEntity<ResponseData> response = client.exchange(request, ResponseData.class);
		return response.getBody();
	}

	@Override
	public ResponseData getCurrencies() {
		URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/reference/v1.0/currencies")
				.queryParam("apikey", apiKey)
				.build().toUri();

		RequestEntity<?> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();

		ResponseEntity<ResponseData> response = client.exchange(request, ResponseData.class);
		return response.getBody();
	}

	@Override
	public String createSession(SessionParameters parameters) {
		URI uri = UriComponentsBuilder.fromUriString(baseUrl + "/pricing/v1.0").build().toUri();

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.set("cabinclass", parameters.getCabinClass().name());
		body.set("country", parameters.getCountry());
		body.set("currency", parameters.getCurrency());
		body.set("locale", parameters.getLocale());
		body.set("locationSchema", "iata");
		body.set("originplace", parameters.getOriginPlace());
		body.set("destinationplace", parameters.getDestinationPlace());
		body.set("outbounddate", parameters.getOutboundDate().format(DateTimeFormatter.ISO_DATE));
		body.set("inbounddate", parameters.getInboundDate().format(DateTimeFormatter.ISO_DATE));
		body.set("adults", parameters.getAdults().toString());
		body.set("children", parameters.getChildren().toString());
		body.set("infants", parameters.getInfants().toString());
		body.set("apikey", apiKey);


		RequestEntity<?> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.body(body);
		ResponseEntity<ResponseData> response = client.exchange(request, ResponseData.class);
		if (response.getStatusCode() == HttpStatus.CREATED) {
			return response.getHeaders().getFirst(HttpHeaders.LOCATION);
		} else {
			throw new RestClientException(response.getStatusCode().name());
		}
	}

	/**
	 * TODO: process 410 Gone
	 * TODO: process 429 Too many requests
	 * @param location
	 * @return
	 */
	@Override
	public PollResponseData pollSession(String location) {
		URI uri = UriComponentsBuilder.fromUriString(location)
				.queryParam("apikey", apiKey)
				.build()
				.toUri();

		RequestEntity<?> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<PollResponseData> response = client.exchange(request, PollResponseData.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else if (response.getStatusCode() == HttpStatus.NOT_MODIFIED) {
			throw new NotModifiedException();
		} else if (response.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
			throw new TooManyRequests();
		} else {
			throw new HttpClientErrorException(response.getStatusCode());
		}
	}


}
