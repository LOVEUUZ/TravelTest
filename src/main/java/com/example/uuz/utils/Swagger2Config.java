package com.example.uuz.utils;

import com.google.common.base.Predicates;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//配置类
@EnableSwagger2//开启swagger2
public class Swagger2Config {
    @Bean//加入ioc容器
    public Docket adminApiConfig(){
        //需要详情配置
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("uuz的api")//swagger组的名字
                .apiInfo(adminApiInfo())
                .select()//必须有select扫描
                //默认路径是controller,因为它是api接口的入口
                .paths(Predicates.and(PathSelectors.regex("/.*")))
                .build();
        return docket;
    }

    private ApiInfo adminApiInfo(){
        Contact ct = new Contact("uuz","https://moying.icu:1998" , "2230726265@qq.com");
        return new ApiInfoBuilder()
                .title("uuz-API测试")
                .description("uuz的测试")
                .termsOfServiceUrl("www.baidu.com")
                .version("0.1")
                .build();

    }

}
 
/*
使用地址
http://localhost:8080/swagger-ui.html
*/