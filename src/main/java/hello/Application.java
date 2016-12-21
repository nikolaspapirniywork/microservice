package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper result = new ObjectMapper();
        result.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        return result;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Start");
    }

}