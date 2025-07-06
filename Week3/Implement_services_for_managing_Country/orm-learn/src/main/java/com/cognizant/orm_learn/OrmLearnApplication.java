package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

//		testGetAllCountries();
//		testAddCountry();
		testUpdateCountry();
	}

	private static void testGetAllCountries() {
		System.out.println("Start");
		List<Country> countries = countryService.getAllCountries();
		for (Country country : countries) {
			System.out.println("Code = " + country.getCode() + ", Name = " + country.getName());
		}
		System.out.println("End");
	}

	private static void testAddCountry() {
		System.out.println("Start");

		Country country = new Country();
		country.setCode("ZZ");
		country.setName("Zootopia");

		countryService.addCountry(country);

		Country fetched = countryService.findCountryByCode("ZZ");

		if (fetched != null) {
			System.out.println("Country added: Code = " + fetched.getCode() + ", Name = " + fetched.getName());
		} else {
			System.out.println("Country not found");
		}

		System.out.println("End");
	}

	private static void testUpdateCountry() {
		System.out.println("Start");

		countryService.updateCountry("IN", "Bharat");

		Country updated = countryService.findCountryByCode("IN");

		if (updated != null) {
			System.out.println("Updated Country: Code = " + updated.getCode() + ", Name = " + updated.getName());
		} else {
			System.out.println("Country not found");
		}

		System.out.println("End");
	}

}
