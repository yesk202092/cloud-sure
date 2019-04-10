package sure;

import com.sun.deploy.net.HttpResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
public class AdminBootStart {

    @RequestMapping(value = "/")
    public String  index(HttpServletResponse response, HttpServletRequest request) throws IOException {
        return "redirect:index";
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminBootStart.class).run(args);
    }
}
