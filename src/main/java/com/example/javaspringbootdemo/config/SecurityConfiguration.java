package com.example.javaspringbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

//  	配置方式跟之前SSM阶段是一样的
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/static/**").permitAll();
//                    auth.anyRequest().authenticated();
//                })
//                .formLogin(conf -> {
//                    conf.loginPage("/login");
//                    conf.loginProcessingUrl("/doLogin");
//                    conf.defaultSuccessUrl("/");
//                    conf.permitAll();
//                })
//                .build();
//    }
}
