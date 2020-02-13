package pl.marek.todoist.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"pl.marek.todoist.domain.todo", "pl.marek.todoist.domain.mail"})
public class MongoConfig {
}
