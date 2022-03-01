package gob.mcu.sgp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${apiUrl}")
    private String apiurl;

    @Value("$apiVersion")
    private String apiVersion;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer){
        configurer.addPathPrefix( apiurl + "/" + apiVersion , HandlerTypePredicate.forAnnotation( RestController.class ));
    }
}
