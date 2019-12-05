package com.cognizant.smartshopservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("admin").password(passwordEncoder().encode("pwd")).roles(
		 * "ADMIN") .and()
		 * .withUser("user").password(passwordEncoder().encode("pwd")).roles(
		 * "USER");
		 */
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
				// .antMatchers("/menu-items").permitAll()
				.antMatchers("/users").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/product").permitAll().antMatchers(HttpMethod.GET, "/**").permitAll()
				.antMatchers(HttpMethod.POST, "/**").permitAll().antMatchers("/authenticate").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated().and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager()));

	}
}
