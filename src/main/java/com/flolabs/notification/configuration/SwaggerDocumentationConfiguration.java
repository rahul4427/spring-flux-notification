package com.flolabs.notification.configuration;

import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SwaggerDocumentationConfiguration {

	@Bean
	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("User's notification").build();
	}
	
	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2)
				 .genericModelSubstitutes(Mono.class, Flux.class, Publisher.class).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).build().apiInfo(apiInfo())
				.tags(new Tag("Notification","Api's related to user's notifications"),
						new Tag("Notify","Api's to send msg to any user"));
	}
}
