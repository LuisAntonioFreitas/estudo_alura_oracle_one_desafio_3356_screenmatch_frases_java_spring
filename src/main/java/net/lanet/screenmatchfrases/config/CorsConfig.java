package net.lanet.screenmatchfrases.config;

import net.lanet.screenmatchfrases.utils.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Autowired
    private ApplicationProperties ap;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        List<String> listHeaders = List.of(ap.apiCorsHeaders.replace(" ","").split(","));
        List<String> listOrigins = List.of(ap.apiCorsOrigins.replace(" ","").split(","));
        List<String> listMethods = List.of(ap.apiCorsMethods.replace(" ","").split(","));

        registry.addMapping("/**")
                .allowedHeaders(listHeaders.toArray(new String[0]))
                .allowedOrigins(listOrigins.toArray(new String[0]))
                .allowedMethods(listMethods.toArray(new String[0]))
                .allowCredentials(true);
    }
}
