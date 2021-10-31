package br.com.mvc.mudi.config;

import br.com.mvc.mudi.interceptor.AcessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AcessInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
