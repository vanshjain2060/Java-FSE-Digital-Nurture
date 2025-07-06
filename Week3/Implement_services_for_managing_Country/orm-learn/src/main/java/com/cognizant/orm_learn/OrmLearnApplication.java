package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger log = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		testGetAllCountries();

		try {
			testFindCountryByCode();
		} catch (CountryNotFoundException e) {
			log.error("Exception: {}", e.getMessage());
		}
	}

	private static void testGetAllCountries() {
		log.info("Start");
		List<Country> countries = countryService.getAllCountries();
		log.debug("countries={}", countries);
		log.info("End");
	}

	private static void testFindCountryByCode() throws CountryNotFoundException {
		log.info("Start");
		Country country = countryService.findCountryByCode("IN");
		log.debug("Country: {}", country);
		log.info("End");
	}


}
