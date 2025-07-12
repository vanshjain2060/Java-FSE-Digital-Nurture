package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CountryController {

    private static final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    @GetMapping("/country")
    public Country getCountryIndia() {
        return (Country) context.getBean("country");
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return (List<Country>) context.getBean("countryList");
    }

    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        List<Country> countryList = (List<Country>) context.getBean("countryList");

        
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found for code: " + code));
    }
}
