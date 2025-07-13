package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CountryController {

    private static final Map<String, Country> countryMap = new HashMap<>();

    static {
        countryMap.put("IN", new Country("IN", "India"));
        countryMap.put("US", new Country("US", "United States"));
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        Country country = countryMap.get(code.toUpperCase());
        if (country == null) {
            throw new CountryNotFoundException("Country not found: " + code);
        }
        return country;
    }

    @ExceptionHandler(CountryNotFoundException.class)
    public String handleCountryNotFoundException(CountryNotFoundException ex) {
        return ex.getMessage();
    }
}
