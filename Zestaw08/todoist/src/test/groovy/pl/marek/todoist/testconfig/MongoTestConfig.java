package pl.marek.todoist.testconfig;

import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@TestConfiguration
@AutoConfigureDataMongo
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "pl.marek.todoist.domain")
public class MongoTestConfig {
}
