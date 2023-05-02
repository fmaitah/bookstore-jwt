package com.fin.fintechbookstore.configurations;

import com.fin.fintechbookstore.services.MyUserDetailsService;
import com.fin.fintechbookstore.utilities.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    final JWTAuthenticationFilter jwtAuthFilter;
    final MyUserDetailsService myUserDetailsService;

    @Bean
    SecurityFilterChain secFilterChain(HttpSecurity http) throws Exception {

        http.csrf()
                .disable().headers().frameOptions().disable().and()
                .authorizeRequests()
                .antMatchers(Constants.AUTH_URL).permitAll().
                antMatchers(Constants.H2_CONSOLE_URL).permitAll()
                .antMatchers(HttpMethod.GET, "/books").permitAll()
                .antMatchers(HttpMethod.GET, "/stores", "/stores/{id}").hasAnyRole(Constants.NORMAL_USER_ROLE, Constants.STORE_ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/**").hasRole(Constants.STORE_ADMIN_ROLE)
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authenticationProvider(authProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).logout();
        ;
        return http.build();
    }

    @Bean
    AuthenticationProvider authProvider() {

        final DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();

        daoAuthProvider.setUserDetailsService(myUserDetailsService);
        daoAuthProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();

    }

}
