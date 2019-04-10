package sure;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
public class AdminBootStart {

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "hellow";
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminBootStart.class).run(args);
    }
}
