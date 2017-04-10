package com.github.tyurin23.skylook.storage;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 19.02.17.
 */
@Configuration
public class MongoConfig {

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(new MongoClient(), "flights");
	}
}
