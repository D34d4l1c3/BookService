package itfbstudy.security;

import itfbstudy.exception.ExceptionHandlerFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .addFilterAfter(new SecurityFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new ExceptionHandlerFilter(), SecurityFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .and()
//                .authorizeRequests()
//                .antMatchers("/books/*").permitAll()
//                .antMatchers("/authors/*").permitAll();
        return http.build();
    }
}