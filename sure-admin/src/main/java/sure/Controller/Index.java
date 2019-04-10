package sure.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("")
public class Index {

    private final static Logger logger = LoggerFactory.getLogger(Index.class);

    @RequestMapping("/index")
    public String index(){
        logger.info("*********************【1.0】");
        logger.info("**********************【2.0】");
        System.out.println("**************");
        return "index";
    }

}
