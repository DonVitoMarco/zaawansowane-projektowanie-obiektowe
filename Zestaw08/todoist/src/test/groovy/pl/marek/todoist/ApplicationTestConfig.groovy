package pl.marek.todoist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import pl.marek.todoist.app.MongoConfig
import pl.marek.todoist.app.SwaggerConfig
import pl.marek.todoist.app.TodoistApplication

@SpringBootApplication
@ComponentScan(basePackages = ["pl.marek.todoist"],
        excludeFilters = [
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = TodoistApplication.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = SwaggerConfig.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MongoConfig.class)
        ])
class ApplicationTestConfig {
}
