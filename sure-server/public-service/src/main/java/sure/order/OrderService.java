package sure.order;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sure-admin",url = "127.0.0.1:8004/")
public interface OrderService {

    @RequestMapping(value = "/admin/getValue",method = RequestMethod.GET)
    String getValue(@RequestParam("str")String str);
}
