package net.lanet.screenmatchfrases.config;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import net.lanet.screenmatchfrases.utils.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Autowired
    private ApplicationProperties ap;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(ap.apiSystemTagBase)
                        .description(ap.apiSystemName)
                        .version(ap.apiSystemVersion)
                );
    }

}
