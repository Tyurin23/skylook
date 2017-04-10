package com.github.tyurin23.skylook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 08.02.17.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);

	}
}
