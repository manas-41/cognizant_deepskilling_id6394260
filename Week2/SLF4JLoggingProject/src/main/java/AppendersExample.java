import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppendersExample {
    private static final Logger logger = LoggerFactory.getLogger(AppendersExample.class);

    public static void main(String[] args) {
        logger.info("This log goes to both console and file!");
        logger.error("This is a test error message.");
    }
}
