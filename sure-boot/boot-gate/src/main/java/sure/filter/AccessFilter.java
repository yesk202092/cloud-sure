package sure.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class AccessFilter  extends ZuulFilter {
    private final static Logger logger = LoggerFactory.getLogger(AccessFilter.class);
    @Value("${spring.application.name}")
    private String name;
    private List<String> paths;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    public AccessFilter(){

    }
    @Override
    public Object run() {

        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request =ctx.getRequest();
        HttpServletResponse response =ctx.getResponse();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        //简单的拦截器
        //String reqUri= request.getRequestURI();
        logger.info(name+":**访问地址****:"+request.getRequestURL());
        return null;
    }
}
