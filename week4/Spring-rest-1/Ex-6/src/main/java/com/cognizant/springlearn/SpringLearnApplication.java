package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("START main()");
        displayCountryList();
        LOGGER.info("END main()");
    }

    public static void displayCountryList() {
        LOGGER.info("START displayCountryList()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country-list.xml");
        List<Country> countryList = (List<Country>) context.getBean("countryList");

        for (Country country : countryList) {
            LOGGER.info("{}", country);
        }

        LOGGER.info("END displayCountryList()");
    }
}
