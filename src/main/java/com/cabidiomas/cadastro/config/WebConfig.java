package com.cabidiomas.cadastro.config;

import org.springframework.core.Ordered;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean(){
        List<String> all = Arrays.asList("*");//Mapea para todos

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(all);
        corsConfiguration.setAllowedHeaders(all);
        corsConfiguration.setAllowedMethods(all);
        //corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);//configura as url
        org.springframework.web.filter.CorsFilter corsFilter = new org.springframework.web.filter.CorsFilter(source);//Filtro dos cors
        FilterRegistrationBean<org.springframework.web.filter.CorsFilter> filter = new FilterRegistrationBean<>(corsFilter);//Registra o cors filters com a url
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);//Define a prioridade do filtro

        return filter;
    }
}
