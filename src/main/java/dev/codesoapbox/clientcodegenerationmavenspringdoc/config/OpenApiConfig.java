package dev.codesoapbox.clientcodegenerationmavenspringdoc.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(
        title = "Planet management API",
        description = "Allows for managing all planets in the galaxy",
        version = "1.0.0"
))
@Configuration
public class OpenApiConfig {
}
