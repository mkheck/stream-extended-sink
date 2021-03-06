package com.thehecklers.sink;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Consumer;

@SpringBootApplication
public class SinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinkApplication.class, args);
	}

}

@Configuration
class PositionLogger {
/*
	@Bean
	Consumer<List<EssentialAircraft>> logIt() {
		return acList -> acList.forEach(System.out::println);
	}
*/
	@Bean
	Consumer<Flux<EssentialAircraft>> logIt() {
		return acList -> acList.subscribe(System.out::println);
	}
}

@Data
class EssentialAircraft {
	private String callsign, reg, type, mfr;
}