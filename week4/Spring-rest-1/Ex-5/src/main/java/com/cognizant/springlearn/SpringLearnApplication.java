package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START main()");
        SpringApplication.run(SpringLearnApplication.class, args);
        compareCountryBeans();
        LOGGER.info("END main()");
    }

    public static void compareCountryBeans() {
        LOGGER.info("START compareCountryBeans()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country-scope.xml");

        Country country1 = context.getBean("country", Country.class);
        Country country2 = context.getBean("country", Country.class);

        LOGGER.debug("Country 1: {}", country1);
        LOGGER.debug("Country 2: {}", country2);

        if (country1 == country2) {
            LOGGER.info("Both country instances are SAME (Singleton scope)");
        } else {
            LOGGER.info("Country instances are DIFFERENT (Prototype scope)");
        }

        LOGGER.info("END compareCountryBeans()");
    }
}
