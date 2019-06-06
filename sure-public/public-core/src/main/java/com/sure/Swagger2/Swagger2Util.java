package com.sure.Swagger2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class Swagger2Util {
    @Value("${admin-swagger.basepackage}")
    private String basepackage;
    @Value("${admin-swagger.service.name}")
    private String titile;
    @Value("${admin-swagger.service.description}")
    private String description;
    @Value("${admin-swagger.service.developer}")
    private String developer;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basepackage))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(titile)
                .description(description)
                .termsOfServiceUrl("")
                .contact(developer)
                .version("1.0")
                .build();
    }
    public Swagger2Util() {
        createRestApi();
        apiInfo();
    }

}
