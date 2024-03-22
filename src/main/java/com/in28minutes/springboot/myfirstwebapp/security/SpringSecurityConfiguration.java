package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
//    @Bean
//    public InMemoryUserDetailsManager creatUserDetailsManager() {
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//            .username("in28Munites")
//            .password("dummy")
//            .roles("USER", "ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

    @Bean
    public InMemoryUserDetailsManager creatUserDetailsManager() {

        UserDetails userDetails1 = createNewUser("in28Minutes", "dummy");
        UserDetails userDetails2 = createNewUser("Ranga", "dummydummy");


        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(final String userName, final String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
            .passwordEncoder(passwordEncoder)
            .username(userName)
            .password(password)
            .roles("USER", "ADMIN")
            .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated()
        );
        http
            .headers((headers) ->
                headers
                    .frameOptions(FrameOptionsConfig::disable)
            );
        http.formLogin(withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
//    @Bean
//
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//            .csrf(AbstractHttpConfigurer::disable)
//            .authorizeHttpRequests(auth -> auth
//                .anyRequest().authenticated()
//            )
//            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .httpBasic(Customizer.withDefaults())
//            .build();
//    }


}
