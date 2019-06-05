package sure.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sure.order.OrderService;

@RestController
@RequestMapping("admin")
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    @GetMapping("getValue")
    public String getValue(String str) {
        return str+"ANXX LOVE LOVE";
    }

    @Override
    public double calculate(int a) {
        return sqrt(a);
    }
}
