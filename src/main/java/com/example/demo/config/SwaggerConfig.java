package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket studentApi(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo(){
        Contact contact = new Contact("william","http://william.com","wmavalle@gmail.com");
        return new ApiInfoBuilder()
                .title("Students API")
                .description("Swagger UI documentation")
                .version("1.0")
                .contact(contact)
                .build();
    }
}
