package pl.marek.todoist.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"pl.marek.todoist.domain"})
@EnableScheduling
@EnableRetry
@Import({SwaggerConfig.class, MongoConfig.class})
public class TodoistApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoistApplication.class, args);
    }
}
