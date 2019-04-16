package sure.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sure.biz.SysRoleBiz;
import sure.order.OrderService;


@Controller
@RequestMapping("admin/")
public class Index {

    private final static Logger logger = LoggerFactory.getLogger(Index.class);
    @Autowired
    private SysRoleBiz sysRoleBiz;
    @Autowired
    private OrderService orderService;
    @RequestMapping("index")
    public String index(){
        logger.info("*********************【1.0】");
        logger.info("**********************【2.0】");
        System.out.println("**************"+sysRoleBiz.getName()+"*****orderService:"+orderService.getValue("yesk and"));
        return "index";
    }

}
