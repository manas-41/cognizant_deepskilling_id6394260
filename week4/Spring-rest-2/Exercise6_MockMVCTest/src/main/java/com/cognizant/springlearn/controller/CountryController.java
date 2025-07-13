package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CountryController {

    private static final Map<String, Country> countryMap = new HashMap<>();

    static {
        countryMap.put("IN", new Country("IN", "India"));
        countryMap.put("US", new Country("US", "United States"));
        countryMap.put("JP", new Country("JP", "Japan"));
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        Country country = countryMap.get(code.toUpperCase());
        if (country == null) {
            throw new CountryNotFoundException("Country not found: " + code);
        }
        return country;
    }
}
