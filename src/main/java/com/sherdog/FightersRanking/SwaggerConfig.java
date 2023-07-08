package com.sherdog.FightersRanking;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.webmvc.api.OpenApiActuatorResource;
import org.springdoc.webmvc.ui.SwaggerConfigResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig  {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("FightersRanking Api")
                        .version("0.1")
                        .description("aplicacion con el ranking de peleadores")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("apache 2.0").url("http://springdoc.org"))
                );

    }

}
