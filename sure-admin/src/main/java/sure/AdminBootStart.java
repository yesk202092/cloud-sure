package sure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "sure.**.dao")
@EnableCaching
public class AdminBootStart {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminBootStart.class).web(true).run(args);
    }
}
