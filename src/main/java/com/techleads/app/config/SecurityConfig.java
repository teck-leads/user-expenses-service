package com.techleads.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http
		.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
        
        .antMatchers(HttpMethod.GET, "/expenses/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/expenses").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/expenses/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/expenses/**").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
