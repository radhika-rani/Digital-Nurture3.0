package com.bookstore.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @SuppressWarnings("deprecation")
	@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false)  // Disable path extension-based content negotiation
                  .favorParameter(true)       // Enable parameter-based content negotiation
                  .parameterName("mediaType") // Name of the parameter
                  .ignoreAcceptHeader(false)  // Use the Accept header
                  .defaultContentType(MediaType.APPLICATION_JSON) // Default content type
                  .mediaType("json", MediaType.APPLICATION_JSON) // Media type for JSON
                  .mediaType("xml", MediaType.APPLICATION_XML); // Media type for XML
    }
}
