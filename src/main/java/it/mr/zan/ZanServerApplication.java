package it.mr.zan;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ZanServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZanServerApplication.class, args);
	}

    /**
     * configurazione di swagger per la generazione della documentazione API
     */
    @Bean
    public Docket apidocConfig() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()
          .apis(RequestHandlerSelectors.basePackage("it.mr.zan.api"))              
          .paths(PathSelectors.regex("/api.*"))
          .build()
          .apiInfo(new ApiInfo(
            "Zan Server",
            "Una semplice API Rest",
            "1.0",
            "Terms of service",
            new Contact("Marco Rosi", "http://www.incodice.it", "marco.rosi@gmail.com"),
           "Apache License Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0",
           Collections.EMPTY_LIST));                           
    }

	/**
	 * abilita cors per l'uso in locale, da evitare in produzione
	 */
	@Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
					.allowedOrigins("*")
					.allowedMethods("*");
            }
        };
    }
}

