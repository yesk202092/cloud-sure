package com.sure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public abstract class BaseController<Biz extends BaseBiz, T extends Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;

    public BaseController() {
    }

    @RequestMapping(
            value = {"/save"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Response save(T entity) {
        this.baseBiz.save(entity);
        return Response.success();
    }

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.PUT}
    )
    @ResponseBody
    public Response update(T entity) {
        this.baseBiz.update(entity);
        return Response.success();
    }

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.DELETE}
    )

    public String getCurrentUserName() {
        String authorization = this.request.getHeader("Authorization");
        return new String(Base64Utils.decodeFromString(authorization));
    }
}
