import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Manaswini";
        int age = 21;

        logger.info("User {} is {} years old.", username, age);
        logger.debug("Debug log for user: {}, age: {}", username, age);
    }
}
