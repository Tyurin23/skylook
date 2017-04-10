package com.github.tyurin23.skylook.skyscanner.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Duration;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 15.02.17.
 */
public class DurationDeserializer extends JsonDeserializer<Duration> {

	@Override
	public Duration deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		int intValue = jsonParser.getIntValue();
		return Duration.ofMinutes(intValue);
	}
}
