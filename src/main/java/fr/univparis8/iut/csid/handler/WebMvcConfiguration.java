package fr.univparis8.iut.csid.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pathIdAndBodyMatcher());
    }

    @Bean
    public PathIdAndBodyMatcher pathIdAndBodyMatcher() {
        return new PathIdAndBodyMatcher();
    }

}
