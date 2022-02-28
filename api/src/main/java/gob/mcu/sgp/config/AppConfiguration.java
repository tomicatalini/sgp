package gob.mcu.sgp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class AppConfiguration {

    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(
                "classpath:/api_error_messages",
                "classpath:/api_response_messages"
        );
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
