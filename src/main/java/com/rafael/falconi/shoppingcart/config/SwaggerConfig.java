package com.rafael.falconi.shoppingcart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig  extends WebMvcConfigurationSupport{

	@Bean
	public Docket api() {
		/*
		 * List<Parameter> parameters = new ArrayList<Parameter>(); ParameterBuilder
		 * parameterBuilder = new ParameterBuilder();
		 * parameters.add(parameterBuilder.name("Authorization").modelRef(new
		 * ModelRef("string")).parameterType("header").required(false).build());
		 */

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());// .pathMapping("").globalOperationParameters(parameters);
	}
	
	// http://localhost:8080/api/v1/swagger-ui.html
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Demo")
                .description("Demo de spring boot with mysql and jpa. https://github.com/rafaelfalconisalazar/spring-mysql").build();
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	
}
