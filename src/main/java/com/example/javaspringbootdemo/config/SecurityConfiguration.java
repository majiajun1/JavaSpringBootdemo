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

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // 允许所有请求，无需登录
            )

            .csrf(csrf -> csrf.disable()) // 关闭 CSRF 保护
            .formLogin(form -> form.disable()) // 关闭默认的登录界面
            .httpBasic(httpBasic -> httpBasic.disable()); // 关闭 HTTP Basic 认证


        return http.build();
    }
}
