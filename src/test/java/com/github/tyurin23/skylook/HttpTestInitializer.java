package com.github.tyurin23.skylook;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = {"it"})
@Ignore
public class HttpTestInitializer {

	@Value("${local.server.port}")
	protected Integer port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
		RestAssured.config().getLogConfig()
				.enableLoggingOfRequestAndResponseIfValidationFails()
				.enablePrettyPrinting(true);
	}
}
