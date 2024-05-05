package com.bysj.equipment.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;


/**
 * 接口文档配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    private boolean swaggerEnabled =true;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/static/swagger/");
    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .select()
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，才生成接口文档
//                .apis(RequestHandlerSelectors.basePackage("com.lfs.modules.*.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("LFS-CMS")
                .description("CMS文档")
                //.termsOfServiceUrl("http://www.ashy.io")
                .version("2.1")
                .build();
    }

    private List<ApiKey> security() {
        List<ApiKey> list=new ArrayList<>();
        list.add(new ApiKey("jsf_token", "token", "header"));
        return list;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContextList = new ArrayList<>();
        List<SecurityReference> securityReferenceList = new ArrayList<>();
        securityReferenceList.add(new SecurityReference("jsf_token", scopes()));
        securityContextList.add(SecurityContext
                .builder()
                .securityReferences(securityReferenceList)
                .forPaths(PathSelectors.any())
                .build()
        );
        return securityContextList;
    }

    /*private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("jsf_token", "token", "header")
        );
    }*/
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("jsf_token", "jsf_token", io.swagger.v3.oas.models.security.SecurityScheme.In.HEADER.toString());
        return Collections.singletonList(apiKey);
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("global", "accessAnything")
        };
    }
}
