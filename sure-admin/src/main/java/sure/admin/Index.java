package sure.admin;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("manage")
public class Index {

    @RequestMapping("index")
    public String index() {

        return "index";
    }

}
