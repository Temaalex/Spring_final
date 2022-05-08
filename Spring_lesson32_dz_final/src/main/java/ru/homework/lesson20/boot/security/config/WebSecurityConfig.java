package ru.homework.lesson20.boot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.homework.lesson20.boot.security.service.UserDetailsServer;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("/api/v1/avia/bay/id", "/api/v1/avia/sale/id").hasRole("USER")

                .antMatchers("/api/v1/avia/add",
                            "/api/v1/avia/update/id",
                            "/api/v1/avia/updateTitle/title/id",
                            "/api/v1/avia/delete/id" ).hasRole("ADMIN")

                .anyRequest().authenticated()
                .and()

                .httpBasic();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return new UserDetailsServer(encoder);
    }
}

