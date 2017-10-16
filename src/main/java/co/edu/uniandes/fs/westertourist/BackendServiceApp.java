package co.edu.uniandes.fs.westertourist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class BackendServiceApp {
    private static final Logger LOGGER = LogManager.getLogger(BackendServiceApp.class);

    public static void main(String[] args) {
        LOGGER.info("Starting BackendServiceApp");
        ConfigurableApplicationContext context = run(BackendServiceApp.class, args);
    }
}
