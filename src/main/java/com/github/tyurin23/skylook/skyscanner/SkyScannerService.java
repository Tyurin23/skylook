package com.github.tyurin23.skylook.skyscanner;

import com.github.tyurin23.skylook.skyscanner.domain.ItineraryComposite;
import com.github.tyurin23.skylook.skyscanner.domain.LegComposite;
import com.github.tyurin23.skylook.skyscanner.domain.SegmentComposite;
import com.github.tyurin23.skylook.skyscanner.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 15.02.17.
 */
@Service
public class SkyScannerService {

	private static final Logger LOG = LoggerFactory.getLogger(SkyScannerService.class);

	private final SkyRepository repository;

	@Autowired
	public SkyScannerService(SkyRepository repository) {
		this.repository = repository;
	}

	public List<ItineraryComposite> getItineraries(SessionParameters parameters, ItineraryFilter filter) {
		LOG.info("Create session: {} ({}) -> {} ({})", parameters.getOriginPlace(), parameters.getOutboundDate(), parameters.getDestinationPlace(), parameters.getInboundDate());
		String session = repository.createSession(parameters);
		LOG.info(session);
		return getItineraries(session, filter);
	}

	public List<ItineraryComposite> getItineraries(String session, ItineraryFilter filter) {
		PollResponseData data = repository.pollSession(session);

		LOG.info("Received {} itineraries", data.getItineraries().size());
		LOG.info(data.getStatus());

		Map<String, Leg> legMap = data.getLegs().stream().collect(Collectors.toMap(Leg::getId, Function.identity()));
		Map<Integer, Segment> segmentMap = data.getSegments().stream().collect(Collectors.toMap(Segment::getId, Function.identity()));

		List<ItineraryComposite> filtered = data.getItineraries().stream()
				.map(i -> mapItineraryToComposite(i, legMap, segmentMap))
				// filter price
				.filter(i -> filterByPrice(i, filter))
				// filter departure duration
//				.filter(i -> Optional.ofNullable(filter.getDepartureFilter().getMaxDuration()).map(d -> i.getOutboundLeg().getDuration().compareTo(d) <= 0).orElse(true))
				.collect(Collectors.toList());

		LOG.info("Filtered {} itineraries", data.getItineraries().size() - filtered.size());
		return filtered;
	}

	private boolean filterByPrice(ItineraryComposite i, ItineraryFilter filter) {
		return Optional.ofNullable(filter.getMaxPrice())
				.map(maxPrice ->
						i.getPricingOptions().stream()
							.map(Price::getPrice)
							.min(Comparator.naturalOrder())
							.map(min -> min < maxPrice)
							.orElse(true)
//							.orElseThrow(() -> new RuntimeException("Min price not found for itinerary"))
				)
				.orElse(true);
	}

	private ItineraryComposite mapItineraryToComposite(Itinerary i, Map<String, Leg> legMap, Map<Integer, Segment> segmentMap) {
		return new ItineraryComposite()
				.setPricingOptions(i.getPricingOptions())
				.setDetailsUrl(i.getDetailsUrl())
				.setOutboundLeg(getLegComposite(legMap, segmentMap, i.getOutboundLegId()))
				.setInboundLeg(getLegComposite(legMap, segmentMap, i.getInboundLegId()));

	}


	private LegComposite getLegComposite(Map<String, Leg> legMap, Map<Integer, Segment> segmentMap, String id) {
		Leg leg = legMap.get(id);
		return new LegComposite()
				.setId(leg.getId())
				.setSegments(leg.getSegments().stream().map(segmentMap::get).map(this::toSegmentComposite).collect(Collectors.toList()))
				.setArrival(leg.getArrival())
				.setDeparture(leg.getDeparture())
				.setDuration((int) leg.getDuration().toMinutes())
				.setFlightNumbers(leg.getFlightNumbers());
	}

	private SegmentComposite toSegmentComposite(Segment s) {
		return new SegmentComposite();
	}


}
