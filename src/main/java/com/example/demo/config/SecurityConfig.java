package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .csrf().and().cors().disable()
                .authorizeRequests()
                .antMatchers("/webjars/**", "/resources/**").permitAll() //webjars og resources skal være der
                .antMatchers("/").permitAll() //permitAll() kan udskiftes med andre roller
                .antMatchers("/bookings/**").permitAll()
                .antMatchers("/bookings/create").permitAll()
                .antMatchers("/services/**").permitAll()
                .antMatchers("/customers/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/sog").hasRole("ADMIN") // "/sog" er tilgængelig for brugere med ADMIN rolle
                .anyRequest()
                .authenticated()
            .and()
            .formLogin()
//               .loginPage("/") //kan give adgang til specifikke sider
            .and()
                .httpBasic()
            .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }
}