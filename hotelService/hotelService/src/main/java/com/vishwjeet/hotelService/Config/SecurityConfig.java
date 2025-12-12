package com.vishwjeet.hotelService.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain (HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hotels/**").hasAuthority("SCOPE_internal")  // ✅ add this
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth -> oauth.jwt());

        return security.build();



    }
}
