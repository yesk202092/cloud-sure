package sure.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class Index {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

}
