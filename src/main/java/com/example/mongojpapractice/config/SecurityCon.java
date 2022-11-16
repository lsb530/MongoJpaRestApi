package com.example.mongojpapractice.config;

import com.example.mongojpapractice.security.core.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityCon {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
            .csrf().disable()
            .cors().configurationSource(corsConfigurationSource()).and()
            .formLogin().disable()
            .logout().disable();

        // Common
        http.authorizeRequests()
            .antMatchers("/error").permitAll();


        // GOWID ADMIN url: /api/v2/gowid/ (*ROLE_SUPER*, *ROLE_ADMIN*, ROLE_GOWID)
        // 나중에 ADMIN 은 제거.
//        http.authorizeRequests()
//            .antMatchers("/api/v2/gowid/login/**").permitAll()
//            .antMatchers("/api/v2/gowid/**").hasAnyRole("GOWID");

        // Shiftee
//        http.authorizeRequests()
//            .antMatchers("/api/v2/shiftee/**").permitAll()
//            .antMatchers("/api/v2/login-with-shiftee/**").permitAll();

//        http.authorizeRequests()
//            .antMatchers("/api/v2/logout", "/api/v2/passwd-check", "/api/v2/passwd", "/api/v2/user/**").hasAnyRole("TEMPUSER")
//            .antMatchers("/api/v2/certificate/**", "/api/v2/register-*", "/api/v2/organization/**",
//                "/api/v2/business/**", "/api/v2/statistics/**", "/api/v2/resource/**",
//                "/api/v2/partnership/**", "/api/v2/payee/**", "/api/v2/payroll/**",
//                "/api/v2/document/**")
//            .hasAnyRole("USER")
//            .antMatchers("/api/v2/**").hasAnyRole("ADMIN")
//            .anyRequest().authenticated();

        http.exceptionHandling()
            .authenticationEntryPoint(new CustomAuthenticationEntryPoint());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addExposedHeader("X-Auth-Token");
        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}