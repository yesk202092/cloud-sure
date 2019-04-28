package sure.admin.api;

import com.sure.Response;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sure.utils.RedisUtil;

@RestController
@RequestMapping("")
@Api(value = "首页")
@Slf4j
public class IndexApi {
    @Autowired
    private RedisUtil redisUtil;
    @ApiOperation(value = "首页")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    @ApiResponses(@ApiResponse(code = 0, message = "首页", response = Response.class))
    public Response index(@ApiParam(value = "平台", required = true) @RequestParam String pat) {
        redisUtil.putCache("1","123");
        return Response.ApiSuccess(redisUtil.getCache("1",String.class));
    }
}
