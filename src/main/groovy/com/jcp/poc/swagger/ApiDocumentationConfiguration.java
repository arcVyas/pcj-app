package com.jcp.poc.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.*;
import org.springframework.context.annotation.ComponentScan;
import com.jcp.poc.controllers.CouponController;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
    CouponController.class
})
public class ApiDocumentationConfiguration {
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
          .groupName("exp-comm")
          .apiInfo(apiInfo())
          .select()
          .paths(regex("/api.*"))
          .build();
    }

    private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
                .title("Exp Comm APIs")
                .description("APIs exposed in JCP-DP exp comm domain")
                .version("0.1")
                .contact("dp: searchAndBrowse team")
                .termsOfServiceUrl("http://jcp-dp-sb.com/terms")
                .license("Internal use")
                .licenseUrl("http://jcp-dp-sb/license")
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
      return UiConfiguration.DEFAULT;
    }
}
