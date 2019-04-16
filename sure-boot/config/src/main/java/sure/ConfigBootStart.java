package sure;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@EnableConfigServer

public class ConfigBootStart {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigBootStart.class).web(true).run(args);
    }
}
